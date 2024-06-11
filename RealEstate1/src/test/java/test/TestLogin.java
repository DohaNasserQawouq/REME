package test;

import Core1.Base;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class TestLogin extends Base {
    LoginPage loginPage;
    SoftAssert softAssert;
    @Test(description = "check that the email and password are mandatory fields",priority = 1)
    public void testLoginWithoutAddPasswordAndEmail(){
        loginPage=new LoginPage(webDriver);
        softAssert=new SoftAssert();
        loginPage.doNotAddTheMandatoryFields();
        softAssert.assertTrue(loginPage.getErrorMessageForEmailField().isDisplayed(),"the error message does not appear for email field");
        softAssert.assertTrue(loginPage.getErrorMessageForPasswordField().isDisplayed(),"the error message does not appear for password field");
        softAssert.assertAll();
    }

    @Test(description = "check add invalid email format",priority = 2)
    public void testLoginWithInvalidEmailFormat(){
        loginPage=new LoginPage(webDriver);
        softAssert=new SoftAssert();
        loginPage.addInvalidEmailFormat();
        softAssert.assertTrue(loginPage.getErrorMessageForInvalidEmailAndMobileFormat().isDisplayed(),"the error message does not appear when you add invalid email format");
        softAssert.assertAll();
    }

    @Test(description = "check add invalid mobile number format",priority = 3)
    public void testLoginWithInvalidMobileFormat(){
        loginPage=new LoginPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        loginPage.addInvalidMobileFormat();
        softAssert.assertTrue(loginPage.getErrorMessageForInvalidEmailAndMobileFormat().isDisplayed(),"the error message does not appear when you add invalid mobile format");
        softAssert.assertAll();
    }

    @Test(description = "check add less than 5 digit in the password field",priority = 4)
    public void testLoginWithLessThan5DigitPassword(){
        loginPage=new LoginPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        loginPage.addLessThan5DigitPasswordNumber();
        softAssert.assertTrue(loginPage.getErrorForLessThan5DigitPassword().isDisplayed(),"the error message does not appear when you add less than 5 digit in the password field");
        softAssert.assertAll();
    }

    @Test(description = "check add invalid password and valid email",priority = 5)
    public void testLoginWithInvalidPasswordAndValidEmail(){
        loginPage=new LoginPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        loginPage.addInvalidPasswordAndValidEmail();
        softAssert.assertTrue(loginPage.getErrorMessageForIncorrectPasswordOrEmailOrMobile().isDisplayed(),"the error message does not appear when you add invalid password ");
        softAssert.assertAll();
    }

    @Test(description = "check add valid password and invalid email",priority = 6)
    public void testLoginWithValidPasswordAndInvalidEmail(){
        loginPage=new LoginPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        loginPage.addInvalidEmailAndValidPassword();
        softAssert.assertTrue(loginPage.getErrorMessageForIncorrectPasswordOrEmailOrMobile().isDisplayed(),"the error message does not appear when you add invalid email ");
        softAssert.assertAll();
    }

    @Test(description = "check add valid password and invalid mobile",priority = 7)
    public void testLoginWithValidPasswordAndInvalidMobile(){
        loginPage=new LoginPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        loginPage.addInvalidMobileAndValidPassword();
        softAssert.assertTrue(loginPage.getErrorMessageForIncorrectPasswordOrEmailOrMobile().isDisplayed(),"the error message does not appear when you add invalid mobile ");
        softAssert.assertAll();
    }

    @Test(description = "check add valid password and valid email",priority = 8)
    public void testLoginWithValidPasswordAndValidEmail(){
        loginPage=new LoginPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        loginPage.addValidEmailAndValidPassword("testdoha@gmail.com","123456");
        softAssert.assertTrue(loginPage.getSearchFieldAfterLogin().isDisplayed(),"you did not login");
        softAssert.assertEquals(webDriver.getCurrentUrl(),"https://bq-realestate.vercel.app/#/","incorrect URL");
        softAssert.assertAll();
    }

    @Test(description = "check add valid password and valid mobile",priority = 9)
    public void testLoginWithValidPasswordAndValidMobile(){
        loginPage=new LoginPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        loginPage.addValidEMobileAndValidPassword();
        softAssert.assertTrue(loginPage.getSearchFieldAfterLogin().isDisplayed(),"you did not login");
        softAssert.assertEquals(webDriver.getCurrentUrl(),"https://bq-realestate.vercel.app/#/","incorrect URL");
        softAssert.assertAll();
    }

}
