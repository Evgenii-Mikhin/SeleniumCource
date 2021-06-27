package tests.base;

import common.CommonActions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.loans.CarLoansPage;
import pages.telecomunications.MobolePhoneReplanishmentPage;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static common.Config.*;

/**
 * Данный     класс хранит в себе создание и инициализацыю драйвера, а так же  вспомогательные методы по работе с жизненным циклом ТЕСТ (@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 */

@ExtendWith(Listener.class)

/**Все тесты наследуемые от BaseTest Запускаются многопоточно. (файл junit-platform.properties)*/
//@Execution(ExecutionMode.CONCURRENT)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected CarLoansPage carLoansPage = new CarLoansPage(driver);
    protected MobolePhoneReplanishmentPage mobolePhoneReplanishmentPage = new MobolePhoneReplanishmentPage(driver);
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

/**Cleaning up allure report and screenshot before passing tests*/
static {
    LOGGER.info("START TIME" + LocalTime.now());
    LOGGER.info("Start clear reports dir: build/reports ...");
    File allureResults = new File("allure-results");
    if(allureResults.isDirectory()){
        for (File item : Objects.requireNonNull(allureResults.listFiles()))
            item.delete();
    }
    if(CLEAR_REPORTS_DIR) {
        File allureScreensots = new File("build/reports/tests");
        for (File item : Objects.requireNonNull(allureScreensots.listFiles()))
            item.delete();

    }

}
    @AfterEach
    /**Clearing cookies after each test (Отчистка куки после каждого теста)*/

    void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterAll
    /**Closing the browser (Закрытие браузера)*/
    void close(){
        if (!HOLD_BROWSER_OPEN){
            driver.close();
        }
    }
}
