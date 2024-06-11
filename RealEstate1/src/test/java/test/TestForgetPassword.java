package test;

import Core1.Base;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ForgetPasswordPage;

public class TestForgetPassword extends Base {
    ForgetPasswordPage forgetPasswordPage;
    SoftAssert softAssert;
    @Test(description = "check click cancel for forget password popup",priority = 1)
    public void testCancelForgetPassword(){
        forgetPasswordPage=new ForgetPasswordPage(webDriver);
        softAssert=new SoftAssert();
        forgetPasswordPage.goToForgetPassword();
        forgetPasswordPage.clickCancelForForgetPasswordPopup();
        softAssert.assertFalse(forgetPasswordPage.getForgetPasswordPopup().isDisplayed(),"the popup still appears");
        softAssert.assertAll();
    }

    @Test(description = "check click X for forget password popup",priority = 2)
    public void testCloseForgetPasswordPopup(){
        forgetPasswordPage=new ForgetPasswordPage(webDriver);
        softAssert=new SoftAssert();
        forgetPasswordPage.goToForgetPassword();
        forgetPasswordPage.clickXForForgetPasswordPopup();
        softAssert.assertFalse(forgetPasswordPage.getForgetPasswordPopup().isDisplayed(),"the popup still appears");
        softAssert.assertAll();
    }

    @Test(description = "check mobile is a mandatory field",priority = 3)
    public void testMandatoryField(){
        forgetPasswordPage=new ForgetPasswordPage(webDriver);
        softAssert=new SoftAssert();
        forgetPasswordPage.goToForgetPassword();
        forgetPasswordPage.doNotAddAnyNumber();
        softAssert.assertTrue(forgetPasswordPage.getErrorWhenYouDidNotAddMobile().isDisplayed(),"error message does not appear");
        softAssert.assertTrue(forgetPasswordPage.getForgetPasswordPopup().isDisplayed(),"the popup still appears");
        softAssert.assertAll();
    }

    @Test(description = "check add invalid mobile format",priority = 4)
    public void testInvalidMobileFormat(){
        forgetPasswordPage=new ForgetPasswordPage(webDriver);
        softAssert=new SoftAssert();
        forgetPasswordPage.AddInvalidMobileFormat();
        softAssert.assertTrue(forgetPasswordPage.getErrorForInvalidMobileFormat().isDisplayed(),"error message does not appear");
        softAssert.assertTrue(forgetPasswordPage.getForgetPasswordPopup().isDisplayed(),"the popup still appears");
        softAssert.assertAll();
    }

    @Test(description = "check add invalid mobile ",priority = 5)
    public void testInvalidMobile(){
        forgetPasswordPage=new ForgetPasswordPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        forgetPasswordPage.goToForgetPassword();
        forgetPasswordPage.AddInvalidMobile();
        softAssert.assertTrue(forgetPasswordPage.getGetErrorForInvalidMobile().isDisplayed(),"error message does not appear");
        softAssert.assertTrue(forgetPasswordPage.getForgetPasswordPopup().isDisplayed(),"the popup still appears");
        softAssert.assertAll();
    }

    @Test(description = "check add valid mobile ",priority = 6)
    public void testValidMobile(){
        forgetPasswordPage=new ForgetPasswordPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        forgetPasswordPage.goToForgetPassword();
        forgetPasswordPage.addValidMobileNumber();
        softAssert.assertTrue(forgetPasswordPage.getResetPasswordPage().isDisplayed(),"you did not go to reset password page");
        softAssert.assertAll();
    }

    @Test(description = "Check the required fields in reset password page",priority = 7)
    public void testMandatoryFieldInResetPassword(){
        forgetPasswordPage=new ForgetPasswordPage(webDriver);
        softAssert=new SoftAssert();
        forgetPasswordPage.doNotAddAnyFieldAndClickSubmit();
        softAssert.assertTrue(forgetPasswordPage.getErrorMessageForPassword().isDisplayed());
        softAssert.assertTrue(forgetPasswordPage.getErrorMessageForConfirmPassword().isDisplayed());
        softAssert.assertTrue(forgetPasswordPage.getErrorMessageForAddOTP().isDisplayed());
        softAssert.assertAll();
    }


    @Test(description = "Check add incorrect OTP",priority = 8)
    public void testAddIncorrectOTP(){
        forgetPasswordPage=new ForgetPasswordPage(webDriver);
        softAssert=new SoftAssert();
        forgetPasswordPage.addIncorrectOTP();
        softAssert.assertTrue(forgetPasswordPage.getErrorMessageForIncorrectOTP().isDisplayed());
        softAssert.assertAll();
    }

    @Test(description = "Check add less than 5 digit for new password ",priority = 9)
    public void testAddLessThan5DigitInNewPassword(){
        forgetPasswordPage=new ForgetPasswordPage(webDriver);
        softAssert=new SoftAssert();
        forgetPasswordPage.addLessThan5DigitPaasword();
        softAssert.assertTrue(forgetPasswordPage.getErrorMessageForAddLessThan5DigitsForNewPassword().isDisplayed());
        softAssert.assertAll();
    }

    @Test(description = "Check Error message when new Password does not match confirm Password ",priority = 10)
    public void testNewPasswordDoesNotMatchConfirmPassword(){
        forgetPasswordPage=new ForgetPasswordPage(webDriver);
        softAssert=new SoftAssert();
        forgetPasswordPage.newPasswordDoesNotMatchConfirmPassword();
        softAssert.assertTrue(forgetPasswordPage.getErrorMessageWhenConfirmPasswordDoesNotMatchPassword().isDisplayed());
        softAssert.assertAll();
    }

    @Test(description = "Check Error message whem add new password same to old password",priority = 11)
    public void testAddPasswordSameToOldPassword(){
        forgetPasswordPage=new ForgetPasswordPage(webDriver);
        softAssert=new SoftAssert();
        forgetPasswordPage.addPasswordSameToOldOne();
        softAssert.assertTrue(forgetPasswordPage.getErrorMessageForUseOldPassword().isDisplayed());
        softAssert.assertAll();
    }

    @Test(description = "Check happy scenario for reset password",priority = 11)
    public void testAddValidData(){
        forgetPasswordPage=new ForgetPasswordPage(webDriver);
        softAssert=new SoftAssert();
        forgetPasswordPage.addValidData();
        softAssert.assertTrue(forgetPasswordPage.getSucessMessage().isDisplayed());
        softAssert.assertAll();
    }

}
