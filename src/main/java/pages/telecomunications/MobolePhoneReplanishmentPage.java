package pages.telecomunications;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class  MobolePhoneReplanishmentPage  extends BasePage {

    public MobolePhoneReplanishmentPage(WebDriver driver) {

        super(driver);
    }

    // Если не использовать WebElement,то к элкменту не будет происсходить обращение если он не используется в тесте.
    // Таким образом можно избежать ошибок с потерянными элементами на странице
    private final By buttonWallet = By.xpath("//div[contains(text(),'My wallet')]");
    private final By inputPhoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
    private final By inputAmount = By.xpath("//input[@data-qa-node='amount']");
    private final By inputCardFrom = By.xpath("//input[@data-qa-node='numberdebitSource']");
    private final By inputCardExpDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    private final By inputCardcvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    private final By buttonSubmitToTheCart = By.xpath("//button[@data-qa-node='submit']");
    private final By paymentDetails = By.xpath("//span[@data-qa-node='details']");

    /**
     *Choose a carg from the wallet
     */
    public MobolePhoneReplanishmentPage selectCardFromWallet() {
        driver.findElement(buttonWallet).click();
        return this;
    }
    /**
     * Enter phone number excluding contry code
     * @param number phone number
     */
    public MobolePhoneReplanishmentPage enterPhoneNumber(String number) {
        driver.findElement(inputPhoneNumber).sendKeys(number);
        return this;
    }
    /**
     * Enter the Amount
     * @param amount
     */
    public MobolePhoneReplanishmentPage enterAmount(String amount) {
        driver.findElement(inputAmount).sendKeys(amount);
        return this;
    }
    /**
     * Enter the number debit card
     * @param card
     */
    public MobolePhoneReplanishmentPage enterCardFrom(String card) {
        driver.findElement(inputCardFrom).sendKeys(card);
        return this;
    }
    /**
     * Enter the card expiration date
     * @param expDate
     */
    public MobolePhoneReplanishmentPage enterCardExpDate(String expDate) {
        driver.findElement(inputCardExpDate).sendKeys(expDate);
        return this;
    }
    /**
     * Enter the cvv card
     * @param cvv
     */
    public MobolePhoneReplanishmentPage enterCvv(String cvv) {
        driver.findElement(inputCardcvv).sendKeys(cvv);
        return this;
    }
    /**
     * Click on the "To the cart" button
     */
    public MobolePhoneReplanishmentPage submitToTheCart(){
        driver.findElement(buttonSubmitToTheCart).click();
        return  this;
    }

    /**
     *
     * @param text
     */
    public MobolePhoneReplanishmentPage checkPaymentDetailsIsPresentInTheCart(String text){
        waitElementIsVisible(driver.findElement(paymentDetails));
        WebElement details = driver.findElement(paymentDetails);
        Assertions.assertEquals(text, details.getText());

        return  this;
    }
}
