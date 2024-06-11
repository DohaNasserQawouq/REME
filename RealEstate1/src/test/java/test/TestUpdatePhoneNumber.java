package test;

import Core1.Base;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.UpdatePhoneNumberPage;

public class TestUpdatePhoneNumber extends Base {
    UpdatePhoneNumberPage updatePhoneNumberPage;
    LoginPage loginPage;
    SoftAssert softAssert;

    @Test(description = "test add exist phone number in phone num. field", priority = 1)
    public void testAddExistPhoneNumber(){
        updatePhoneNumberPage=new UpdatePhoneNumberPage(webDriver);
        loginPage= new LoginPage(webDriver);
        softAssert=new SoftAssert();
        loginPage.addValidEmailAndValidPassword("testdoha@gmail.com","123456");
        updatePhoneNumberPage.goToPersonalInformationScreen();
        updatePhoneNumberPage.addExistMobileNumber();
        softAssert.assertTrue(updatePhoneNumberPage.getMessageForAddExistPhoneNumber().isDisplayed(),"you can add exist mobile number");
        softAssert.assertAll();
    }

    @Test(description = "test add less than 10 digit for phone number",priority = 2)
    public void testAddIncorrectPhoneNumber(){
        updatePhoneNumberPage=new UpdatePhoneNumberPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        updatePhoneNumberPage.AddIncorrectPhoneNumber();
        softAssert.assertTrue(updatePhoneNumberPage.getMessageForAddIncorrectPhoneNumber().isDisplayed(),"you can add incorrect number");
        softAssert.assertAll();

    }

    @Test(description = "check if the phone number appear as a mandatory field",priority = 3)
    public void testMandatoryField(){
        updatePhoneNumberPage=new UpdatePhoneNumberPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        updatePhoneNumberPage.doNotAddAnyValueInThePhoneField();
        softAssert.assertTrue(updatePhoneNumberPage.getMessageForCheckPhoneNumberAsAMandatoryField().isDisplayed(),"the phone number is not mandatory");
        softAssert.assertAll();
    }

    @Test(description = "test add correct phone number",priority = 4)
    public void testAddCorrectPhoneNumber(){
        updatePhoneNumberPage=new UpdatePhoneNumberPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        updatePhoneNumberPage.testAddNewCorrectPhoneNumber();
        softAssert.assertTrue(updatePhoneNumberPage.goToCertificateCode().isDisplayed(),"you did not go to add certification code");
        softAssert.assertAll();

    }

    @Test(description = "test that code field is mandatory field",priority = 5)
    public void testMandatoryFieldForConfirmPhoneNumber(){
        updatePhoneNumberPage=new UpdatePhoneNumberPage(webDriver);
        softAssert=new SoftAssert();
        updatePhoneNumberPage.checkCodeFieldIsMandatory();
        softAssert.assertTrue(updatePhoneNumberPage.getMessageForDidNotAddCode().isDisplayed(),"code field is not mandatory field");
        softAssert.assertAll();
    }

    @Test(description = "test add incorrect verification code",priority = 6)
    public void testAddIncorrectCode(){
        updatePhoneNumberPage=new UpdatePhoneNumberPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        updatePhoneNumberPage.testAddNewCorrectPhoneNumber();
        updatePhoneNumberPage.addWrongVerificationCode();
        softAssert.assertTrue(updatePhoneNumberPage.getMessageForAddIncorrectCode().isDisplayed(),"you can add incorrect confirmation code");
        softAssert.assertAll();
    }

    @Test(description = "check resubmit verification code",priority = 7)
    public void testResubmitVerificationCode(){
        updatePhoneNumberPage=new UpdatePhoneNumberPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        updatePhoneNumberPage.testAddNewCorrectPhoneNumber();
        updatePhoneNumberPage.resubmitVerificationCode();
        softAssert.assertTrue(updatePhoneNumberPage.getSuccessMessageForResendVerificationCode().isDisplayed(),"you can not resubmit the code");
        softAssert.assertAll();
    }

    @Test(description = "check update phone number by add correct phone number and correct code",priority = 8)
    public void testUpdatePhoneNumber(){
        updatePhoneNumberPage=new UpdatePhoneNumberPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        updatePhoneNumberPage.testAddNewCorrectPhoneNumber();
        updatePhoneNumberPage.addCorrectCode();
        softAssert.assertTrue(updatePhoneNumberPage.getSuccessMessageForUpdatePhoneNumber().isDisplayed(),"you can not update your phone number");
        softAssert.assertAll();
    }

}
