package tests.loans.positive;

import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.CAL_LOANS_URL;

public class CarLoansPisitiveTest extends BaseTest {
   @Test
    public void selectAgreementsTabInPublicSession(){
        basePage.goToUrl(CAL_LOANS_URL);
        carLoansPage.selectAgreementsTab();
        basePage.isAythWidgetPresent();
    }
}
