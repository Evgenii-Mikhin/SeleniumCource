package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Constant.TimeutVeriables.EXPLICIT_WAIT;

/**
 * В данном класе будут расположены методы похожие/одинаковые для всех страниц
 */
public class BasePage {

    public WebDriver driver;
    public  BasePage(WebDriver driver) {

        this.driver = driver;
    }
    public  final By authWibget = By.xpath("//iframe[@src='https://login-widget.privat24.ua/']");

    /**
     *The method for navigation a specific URL (Метод для перехода на поерделенную страницу)
     */
    public void goToUrl(String url){
     driver.get(url);
    }

    /**
     * Wait foe visability element in DOM model (Явное ожидание)
     */
    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver,EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
    /**
     * Check is auth frame is visable (Ожидание страницы регистрации)
     */
    public void isAythWidgetPresent(){
        WebElement authFrame = driver.findElement(authWibget);
        waitElementIsVisible(authFrame);
}
}
