package test;

import Core1.Base;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ChangePasswordPage;
import pages.LoginPage;

public class TestChangePassword extends Base {
    LoginPage loginPage;
    ChangePasswordPage changePasswordPage;
    SoftAssert softAssert;

    @Test(description = "check the mandatory fields", priority = 1)
    public void testMandatoryFields(){
        loginPage=new LoginPage(webDriver);
        changePasswordPage=new ChangePasswordPage(webDriver);
        softAssert=new SoftAssert();
        loginPage.addValidEmailAndValidPassword("testdoha@gmail.com","123456");
        changePasswordPage.goToPersonalInfo();
        changePasswordPage.checkMandatoryFields();
        softAssert.assertTrue(changePasswordPage.getMessageForConfirmPasswordAsAMandatory().isDisplayed(),"the confirm password does not appear as a mandatory field");
        softAssert.assertTrue(changePasswordPage.getMessageForCurrentPasswordAsAMandatory().isDisplayed(),"current password field is not a mandatory field");
        softAssert.assertTrue(changePasswordPage.getMessageForNewPasswordAsAMandatory().isDisplayed(),"new password field does not a mandatory field");
        softAssert.assertAll();
    }

    @Test(description = "test add incorrect current password", priority = 2)
    public void addIncorrectCurrentPassword(){
        changePasswordPage=new ChangePasswordPage(webDriver);
        changePasswordPage.addIncorrectCurrentPassword();
        Assert.assertTrue(changePasswordPage.getMessageForIncorrectCurrentPassword().isDisplayed(),"the error message for incorrect current password does not appear");
    }

    @Test(description = "check add less than 5 didit for new password field",priority = 3)
    public void addLessThan5DigitInPasswordField(){
        changePasswordPage=new ChangePasswordPage(webDriver);
        changePasswordPage.addLessThan5DigitsInTheNewPasswordField();
        Assert.assertTrue(changePasswordPage.getMessageForAddLessThan5DigitInPasswordField().isDisplayed(),"the error message for add less than 5 digit does not appear");
    }

    @Test(description = "check add new password same to old one",priority = 4)
    public void testAddNewPasswordSameToOldOne(){
        changePasswordPage=new ChangePasswordPage(webDriver);
        changePasswordPage.addNewPasswordSameToPreviousPassword();
        Assert.assertTrue(changePasswordPage.getMessageWhenTheOldPasswordMatchNewPassword().isDisplayed(),"the error message does not appear when you add new password same to old one");
    }

    @Test(description = "check error message when add confirm password does not match new password",priority = 5)
    public void testAddConfirmPasswordDoesNotNewOne(){
        changePasswordPage=new ChangePasswordPage(webDriver);
        changePasswordPage.addConfirmPasswordDoesNotMatchNewPassword();
        Assert.assertTrue(changePasswordPage.getMessageWhenThePasswordDoesNotMatchConfirmPassword().isDisplayed(),"the error message does not appear when you add confirm password does not match new password");
    }

    @Test(description = "check change the old password",priority = 6)
    public void testHappyScenarioToChangePassword(){
        changePasswordPage=new ChangePasswordPage(webDriver);
        changePasswordPage.changeTheCurrentPassword();
        Assert.assertTrue(changePasswordPage.getSuccessMessageForChangePassword().isDisplayed(),"you can not change the current password");
    }

}
