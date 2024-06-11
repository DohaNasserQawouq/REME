package test;

import Core1.Base;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AddToFavorite;
import pages.LoginPage;

public class TestAddToFavorite extends Base {
    LoginPage loginPage;
    AddToFavorite addToFavorite;
     SoftAssert softAssert;

     @Test(description = "test add to favorite", priority = 1)
    public void addToFavorite(){
         loginPage=new LoginPage(webDriver);
         addToFavorite=new AddToFavorite(webDriver);
         softAssert=new SoftAssert();
         loginPage.addValidEmailAndValidPassword("testdoha@gmail.com","123456");
         addToFavorite.goToFavoriteAssetsAndAuctions();
         int numberOfAuctionBefore= addToFavorite.getTheNumberOfAuctions();
         addToFavorite.clickAddFavorite();
         softAssert.assertTrue(addToFavorite.getAddSuccessMessage().isDisplayed(),"the added succcess message does not appear");
         addToFavorite.moveToAddFavorite();
         softAssert.assertTrue(addToFavorite.getMessageWhenGoToFavourite().isDisplayed(),"the delete statement does not appear");
         addToFavorite.goBackToFavoriteAssetsAndAuctions();
         webDriver.navigate().refresh();
         int numberOfAuctionAfter= addToFavorite.getTheNumberOfAuctions();
         softAssert.assertTrue(numberOfAuctionAfter>numberOfAuctionBefore,"the number of auctions does not change");
         softAssert.assertAll();
     }

     @Test(description = "test delete the auction from my favorite list", priority = 2)
    public void deleteTheAuctionFromTheFavorite(){
         addToFavorite=new AddToFavorite(webDriver);
         softAssert=new SoftAssert();
         int numberOfAuctionsBefore= addToFavorite.getTheNumberOfAuctions();
         addToFavorite.clickRemoveFromFavorite();
         softAssert.assertTrue(addToFavorite.getDeleteFromFavoriteSuccessMessage().isDisplayed(),"the delete from favorite message does not appear");
         addToFavorite.moveToAddFavorite();
         softAssert.assertTrue(addToFavorite.getAddToFavoriteMessage().isDisplayed(),"the add to favorite message does not appear");
         addToFavorite.goBackToFavoriteAssetsAndAuctions();
         webDriver.navigate().refresh();
         int numberOfAuctionAfter= addToFavorite.getTheNumberOfAuctions();
         softAssert.assertTrue(numberOfAuctionAfter<numberOfAuctionsBefore, "the number of auction appears incorrectly");
         softAssert.assertAll();
     }
}
