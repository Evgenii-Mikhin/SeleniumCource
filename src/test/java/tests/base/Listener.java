package tests.base;

import ch.qos.logback.core.util.FileUtil;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Listener implements TestWatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Override

    /**Taking a screenshot when the test fails (Создание скриншота при падении теста)*/
    public void testFailed(ExtensionContext context,Throwable cause){
        LOGGER.info("Test {} - FAILED", context.getTestMethod().get().getName());
        String screanchotName = context.getTestMethod().get().getName() +
                String.valueOf(System.currentTimeMillis()).substring(9,13);
        LOGGER.info("Trying to trace screnshot...");
        TakesScreenshot ts = (TakesScreenshot) ((BaseTest)context.getRequiredTestInstance()).driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(source, new File("build/reports/tests/" + screanchotName + ".png"));
        } catch (IOException e) {
            LOGGER.info("Exception on saving screanhot!");
            e.printStackTrace();
        }
        attachScreenshotToAllure(ts);
    }

    /**Adding a screenshot to the allure report (Добавление скриншота к allure отчету)*/
    @Attachment
    public  byte[] attachScreenshotToAllure(TakesScreenshot takesScreenshot){
    return takesScreenshot.getScreenshotAs(OutputType.BYTES);
}
}
