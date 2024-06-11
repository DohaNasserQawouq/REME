package test;

import Core1.Base;
import Core1.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SignUpPage;

public class TestSignUp extends Base {
    SignUpPage signUpPage;
    SoftAssert softAssert;

    @Test(description = "test go to login page when click on login button",priority = 1)
    public void testGoToLogin(){
        signUpPage=new SignUpPage(webDriver);
        signUpPage.goToSignUp();
        signUpPage.goToLogin();
        Assert.assertTrue(signUpPage.getLoginPage().isDisplayed(),"the login page does not appear");
    }
    @Test(description = "test signup with exist email",priority = 2)
    public void testSignupWithExistEmail(){
        signUpPage=new SignUpPage(webDriver);
        softAssert= new SoftAssert();
        signUpPage.goToSignUp();
        signUpPage.SignUpWithExistEmail();
        softAssert.assertTrue(signUpPage.errorMessageForExistEmail().isDisplayed(),"the error message for exist email does not appear");
        softAssert.assertEquals(webDriver.getCurrentUrl(),"https://bq-realestate.vercel.app/#/register","incorrect URL for exist email");
        softAssert.assertAll();
    }
    @Test(description = "test signup with exist mobile number", priority = 3)
    public void testSignUpWithExistMobileNumber(){
        signUpPage=new SignUpPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        signUpPage.signUpWithExistMobileNumber();
        softAssert.assertTrue(signUpPage.getErrorMessageForExistMobileNumber().isDisplayed(),"the error message for exist cell number does not appear");
        softAssert.assertEquals(webDriver.getCurrentUrl(),"https://bq-realestate.vercel.app/#/register","incorrect URL for exist cell number");
        softAssert.assertAll();
    }
    @Test(description = "test signup with incorrect mobile number(number less than 5 digit)", priority = 4)
    public void testSignupWithIncorrectPassword(){
        signUpPage=new SignUpPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        signUpPage.signUpWithIncorrectPassword();
        softAssert.assertTrue(signUpPage.getErrorMessageForIncorrectPassword().isDisplayed(),"the error message for incorrect password does not appear");
        softAssert.assertEquals(webDriver.getCurrentUrl(),"https://bq-realestate.vercel.app/#/register","incorrect URL for incorrect password");
        softAssert.assertAll();
    }
    @Test(description ="test uncheck the checkbox",priority = 5)
    public void testUncheckConditionsCheckbox(){
        signUpPage=new SignUpPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        signUpPage.signUPWithoutCheckTheCheckbox();
        softAssert.assertEquals(signUpPage.getColorForConditionSentence(),"rgba(255, 77, 79, 1)","incorrect color");
        softAssert.assertEquals(webDriver.getCurrentUrl(),"https://bq-realestate.vercel.app/#/register","incorrect URL for incorrect password");
        softAssert.assertAll();
    }
    @Test(description = "test signup with invalid email",priority = 6)
    public void testInvalidEmail(){
        signUpPage=new SignUpPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        signUpPage.signupWithInvalidEmail();
        softAssert.assertTrue(signUpPage.getErrorMessageForInvalidEmail().isDisplayed(),"incorrect error message");
        softAssert.assertEquals(webDriver.getCurrentUrl(),"https://bq-realestate.vercel.app/#/register","incorrect URL for invalid email");
        softAssert.assertAll();

    }
    @Test(description = "check the mandatory field",priority = 7)
    public void testMandatoryField(){
        signUpPage=new SignUpPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        signUpPage.doNotAddAnyValueInTheRequiredField();
        softAssert.assertTrue(signUpPage.getErrorMessageForNameField().isDisplayed(),"the name is not mandatory");
        softAssert.assertTrue(signUpPage.getErrorMessageForEmailField().isDisplayed(),"the email field is not mandatory");
        softAssert.assertTrue(signUpPage.getErrorMessageForCellField().isDisplayed(),"cell field is not mandatory");
        softAssert.assertTrue(signUpPage.getErrorMessageForPasswordField().isDisplayed(),"password field is not mandatory");
        softAssert.assertEquals(signUpPage.getColorForConditionSentence(),"rgba(255, 77, 79, 1)","incorrect color");
        softAssert.assertEquals(webDriver.getCurrentUrl(),"https://bq-realestate.vercel.app/#/register","incorrect URL for mandatory fields");
        softAssert.assertAll();
    }

    @Test(description = "test signup with valid data(happy scenario",priority = 8)
    public void testSignupWithValidData(){
        signUpPage=new SignUpPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        signUpPage.signupWithValidData();
        softAssert.assertTrue(signUpPage.getConfirmAccount().isDisplayed(),"do not go to add OTP");
        softAssert.assertEquals(webDriver.getCurrentUrl(),"https://bq-realestate.vercel.app/#/otp-verify","incorrect URL");
        softAssert.assertAll();
    }

    }


