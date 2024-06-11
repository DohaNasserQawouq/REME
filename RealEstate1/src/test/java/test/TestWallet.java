package test;

import Core1.Base;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.WalletPage;

public class TestWallet extends Base {
    WalletPage walletPage;
    SoftAssert softAssert;
    LoginPage loginPage;

    @Test(description = "test the mandatory fields in add subscription popup",priority = 1)
    public void checkTheMandatoryFields(){
        walletPage=new WalletPage(webDriver);
        softAssert=new SoftAssert();
        loginPage=new LoginPage(webDriver);
        loginPage.addValidEmailAndValidPassword("testdoha@gmail.com","123456");
        walletPage.goToWallet();
        walletPage.doNotAddMandatoryFields();
        softAssert.assertTrue(walletPage.getErrorMessageForAmountField().isDisplayed(),"the error does not appear");
        softAssert.assertTrue(walletPage.getErrorMessageForApprovePayment().isDisplayed(),"the error message does not appear");
        softAssert.assertAll();
    }

    @Test(description = "close add subscription popup", priority = 2)
    public void testCloseButton(){
        walletPage=new WalletPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        walletPage.clickCloseForAddSubscriptionPopup();
    }

    @Test(description = "check cancel button in the add subscription popup",priority = 3)
    public void testCancelButton(){
        walletPage=new WalletPage(webDriver);
        softAssert=new SoftAssert();
        walletPage.clickCloseForAddSubscriptionPopup();
    }
    @Test(description = "check add new subscription", priority = 4)
    public void testAddSubscriptions() throws InterruptedException {
        walletPage=new WalletPage(webDriver);
        softAssert=new SoftAssert();
        walletPage.addSubscribtion("1200");
        softAssert.assertTrue(walletPage.gitAddSubscriptionSucessMessage().isDisplayed(),"you did not add the subscription correctly");
        softAssert.assertTrue(walletPage.checkTheAddedAmount("1,200.00").isDisplayed(),"the amount does not appear");
        softAssert.assertAll();

    }
}
