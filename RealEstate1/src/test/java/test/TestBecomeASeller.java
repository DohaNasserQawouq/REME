package test;

import Core1.Base;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BecomeASellerPage;
import pages.LoginPage;

public class TestBecomeASeller extends Base {
    BecomeASellerPage becomeASellerPage;
    SoftAssert softAssert;

    @Test(description = "test the required fields in the become a seller page",priority = 1)
    public void testMandatoryFields() throws InterruptedException {
        LoginPage loginPage= new LoginPage(webDriver);
        loginPage.addValidEmailAndValidPassword("testdoha@gmail.com","123456");
        becomeASellerPage=new BecomeASellerPage(webDriver);
        becomeASellerPage.goToBecomeASeller();
        becomeASellerPage.checkTheRequiredFields();
        softAssert=new SoftAssert();
        softAssert.assertTrue(becomeASellerPage.getThisFieldIsRequiredMessageForNameField().isDisplayed(),"name field is not required");
        softAssert.assertTrue(becomeASellerPage.getThisFieldIsRequiredMessageForDescriptionField().isDisplayed(),"description field is not required");
        softAssert.assertTrue(becomeASellerPage.getThisFieldIsRequiredMessageForAddImage().isDisplayed(),"add image is not a required");
        softAssert.assertTrue(becomeASellerPage.getThisFieldIsRequiredMessageForFallNumberField().isDisplayed(),"fall number is not required");
        softAssert.assertTrue(becomeASellerPage.getThisFieldIsRequiredMessageForFallExpiryDateField().isDisplayed(),"fall expiry date is not required");
        softAssert.assertTrue(becomeASellerPage.getThisFieldIsRequiredMessageForPhoneNumber1Field().isDisplayed(),"phone number 1 is not required");
        softAssert.assertAll();
    }

    @Test(description = "test add less than 10 digit in the first phone number field", priority = 2)
    public void testAddLessThan10DigitInTheFirstMobileNumberField() throws InterruptedException {
        becomeASellerPage=new BecomeASellerPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        becomeASellerPage.addLessThan10DigitInFirstPhoneNum();
        softAssert.assertTrue(becomeASellerPage.gitErrorMessageForAddIncorrectPhoneNumber().isDisplayed(),"the error message does not appear for the invalid phone number");
        softAssert.assertAll();

    }

    @Test(description = "test add less than 10 digit in the second phone number field", priority = 3)
    public void testAddLessThan10DigitInTheSecondMobileNumberField() {
        becomeASellerPage=new BecomeASellerPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        becomeASellerPage.addLessThan10DigitInSecondPhoneNum();
        softAssert.assertTrue(becomeASellerPage.gitErrorMessageForAddIncorrectPhoneNumber().isDisplayed(),"the error message does not appear for the invalid second phone number");
        softAssert.assertAll();

    }

    @Test(description = "test add less than 10 digit in the whatsApp number field", priority = 4)
    public void testAddLessThan10DigitInTheWhatsAppNumberField() {
        becomeASellerPage=new BecomeASellerPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        becomeASellerPage.addLessThan10DigitInWhatAppNum();
        softAssert.assertTrue(becomeASellerPage.gitErrorMessageForAddIncorrectPhoneNumber().isDisplayed(),"the error message does not appear for the invalid whatsapp number");
        softAssert.assertAll();

    }

    @Test(description = "test add less correct data and send become a seller request", priority = 5)
    public void testSendBecomeASellerRequest() {
        becomeASellerPage=new BecomeASellerPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        becomeASellerPage.addValidDataInAllFields();
        softAssert.assertTrue(becomeASellerPage.gitSuccessMessage().isDisplayed(),"the success message does not appear");
        softAssert.assertAll();

    }
}
