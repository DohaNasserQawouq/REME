package test;

import Core1.Base;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ContactUsPage;

public class TestContactUs extends Base {
    ContactUsPage contactUsPage;
    SoftAssert softAssert;

    @Test(description = "check the mandatory fields",priority = 1)
    public void testTheMandatoryFields(){
        contactUsPage=new ContactUsPage(webDriver);
        softAssert=new SoftAssert();
        contactUsPage.doNotAddTheMandatoryFields();
        softAssert.assertTrue(contactUsPage.getErrorMessageForName().isDisplayed());
        softAssert.assertTrue(contactUsPage.getErrorMessageForCell().isDisplayed());
        softAssert.assertTrue(contactUsPage.getErrorMessageForEmail().isDisplayed());
        softAssert.assertTrue(contactUsPage.getErrorMessageForYourMessage().isDisplayed());
        softAssert.assertAll();

    }

    @Test(description = "check error message for add invalid cell number",priority = 2)
    public void testInvalidCellNumber(){
        contactUsPage=new ContactUsPage(webDriver);
        softAssert=new SoftAssert();
        contactUsPage.addIncorrectCellNumber();
        softAssert.assertTrue(contactUsPage.getErrorMessageForInvalidCellNumberFormat().isDisplayed());
        softAssert.assertAll();}

    @Test(description = "check error message for add invalid email format",priority = 3)
    public void testInvalidEmailFormat(){
        contactUsPage=new ContactUsPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        contactUsPage.addInvalidEmailFormat();
        softAssert.assertTrue(contactUsPage.getErrorMessageForInvalidEmailFormat().isDisplayed());
        softAssert.assertAll();}

    @Test (description = "check add valid data and submit the request",priority = 4)
    public void testISubmitContactUsRequest(){
        contactUsPage=new ContactUsPage(webDriver);
        softAssert=new SoftAssert();
        webDriver.navigate().refresh();
        contactUsPage.addValidData();
        softAssert.assertTrue(contactUsPage.getSuccessMessage().isDisplayed());
        softAssert.assertEquals(webDriver.getCurrentUrl(),"https://bq-realestate.vercel.app/#/");
        softAssert.assertAll();}

}
