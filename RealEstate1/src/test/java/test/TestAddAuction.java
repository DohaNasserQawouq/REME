package test;

import Core1.Base;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AddAuctionPage;
import pages.AddToFavorite;
import pages.LoginPage;

public class TestAddAuction extends Base {
    LoginPage loginPage;

    AddAuctionPage addAuctionPage;

    SoftAssert softAssert;
    @Test(description = "test the mandatory fields ", priority = 1)
    public void checkTheMandatoryFields(){
        loginPage=new LoginPage(webDriver);
        addAuctionPage=new AddAuctionPage(webDriver);
        softAssert=new SoftAssert();
        loginPage.addValidEmailAndValidPassword("testseven@gmail.com","123456");
        addAuctionPage.goToAddAuction();
        addAuctionPage.doNotAddTheMandatoryFields();
        softAssert.assertTrue(addAuctionPage.getMandatoryMessageForNameField().isDisplayed(),"the name field is a non mandatory field");
        softAssert.assertTrue(addAuctionPage.getMandatoryMessageForDescriptionField().isDisplayed(),"the description field is a non mandatory field");
        softAssert.assertTrue(addAuctionPage.getMandatoryMessageForImageField().isDisplayed()," image field is a non mandatory field");
        softAssert.assertTrue(addAuctionPage.getMandatoryMessageForPhoneNumberField().isDisplayed(),"phone number is a non mandatory field");
    }
    @Test(description = "test view the added picture",priority = 2)
    public void testViewAddedPicture(){
        addAuctionPage=new AddAuctionPage(webDriver);
        softAssert=new SoftAssert();
        addAuctionPage.viewTheAddedImage();
        softAssert.assertTrue(addAuctionPage.thePictureAppear().isDisplayed(),"the picture does not appear");
        addAuctionPage.closeTheImage();
        softAssert.assertAll();
    }

    @Test(description = "test add incorrect phone number", priority = 3)
    public void testAddIncorrectPhoneNumber(){
        addAuctionPage=new AddAuctionPage(webDriver);
        softAssert=new SoftAssert();
        addAuctionPage.addInvalidPhoneNumber();
        softAssert.assertTrue(addAuctionPage.getMessageForIncorrectMobileNumber().isDisplayed(),"the error message does not appear when you add incorrect phone number");
        softAssert.assertAll();
    }

    @Test(description = "test add incorrect whatsapp number", priority = 4)
    public void testAddIncorrectWhatsappNumber(){
        addAuctionPage=new AddAuctionPage(webDriver);
        softAssert=new SoftAssert();
        addAuctionPage.addIncorrectWhatsappNumber();
        softAssert.assertTrue(addAuctionPage.getMessageForIncorrectWhatsappNumber().isDisplayed(),"the error message does not appear when you add incorrect whatsapp");
        softAssert.assertAll();
    }
}
