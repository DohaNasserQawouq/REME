package test;

import Core1.Base;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AuctionAlertPage;
import pages.LoginPage;

import java.time.Duration;

public class TestAuctionAlert extends Base {
    AuctionAlertPage auctionAlertPage;
    SoftAssert softAssert;
    LoginPage loginPage;

@Test(description = "test add auction alert" , priority = 1)
    public void testAddNewAlert(){
    auctionAlertPage=new AuctionAlertPage(webDriver);
    loginPage=new LoginPage(webDriver);
    softAssert=new SoftAssert();
    loginPage.addValidEmailAndValidPassword("testdoha@gmail.com","123456");
    auctionAlertPage.goToAuctionAlert();
    auctionAlertPage.addWord("test");
    softAssert.assertTrue(auctionAlertPage.addSuccessMessage().isDisplayed(),"the success message does not appear");
    softAssert.assertTrue(auctionAlertPage.addedWord("test").isDisplayed(),"the new value does not appear");
    softAssert.assertAll();
}

@Test(description = "test close button in the edit auction alert popup",priority = 2)
    public void testCloseEditPopup(){
    auctionAlertPage=new AuctionAlertPage(webDriver);
    softAssert=new SoftAssert();
    auctionAlertPage.testCloseButtonForEdit("test");
    softAssert.assertTrue(auctionAlertPage.oldWordAppear("test").isDisplayed(),"the old word does not appear");
    softAssert.assertAll();
}

@Test(description = "test x button in the edit auction alert popup", priority = 3)
    public void testXButton(){
    auctionAlertPage=new AuctionAlertPage(webDriver);
    softAssert=new SoftAssert();
    auctionAlertPage.clickCancelInTheEditPopup("test");
    softAssert.assertTrue(auctionAlertPage.oldWordAppear("test").isDisplayed(),"the old word does not appear");
    softAssert.assertAll();
}
@Test(description = "test edit auction alert",priority = 4)
    public void testEditAuctionAlert()  {
    auctionAlertPage=new AuctionAlertPage(webDriver);
    softAssert=new SoftAssert();
    auctionAlertPage.editTheAuctionAlert("test","testing");
    softAssert.assertTrue(auctionAlertPage.editSuccessMessage().isDisplayed(),"the edit success message does not appear");
    softAssert.assertTrue(auctionAlertPage.alertAfterEdit("testing").isDisplayed(),"the new word does not appear");
    softAssert.assertAll();
}
@Test(description = "test delete alert",priority = 5)
    public void testDeleteAuctionAlert(){
    auctionAlertPage=new AuctionAlertPage(webDriver);
    softAssert=new SoftAssert();
    int numberBeforeDelete=auctionAlertPage.gitNumberOfAuctionAlert();
    auctionAlertPage.deleteAlert("testing");
    softAssert.assertTrue(auctionAlertPage.getSuccessMessageForDelete().isDisplayed(),"the success message for delete does not appear");
    int numberAfterDelete=auctionAlertPage.gitNumberOfAuctionAlert();
    softAssert.assertTrue(numberBeforeDelete==numberAfterDelete,"the auction alert deleted");
    softAssert.assertAll();

}
}
