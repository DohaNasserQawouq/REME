package pages;

import Core1.Base;
import Core1.ElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Core1.Base.webDriver;
import static Core1.ElementHelper.elementToBeVisible;

public class AddToFavorite {
    public AddToFavorite(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(css = "[placeholder=\"ابحث باستخدام الكلمات المفتاحية\"]")
    private WebElement searchField;

    @FindBy(xpath = "//span[text()='مشاهدة التفاصيل']")
    private WebElement moreDetailsButton;

    @FindBy(xpath = "//*[@class=\"feather feather-heart\"]")
    private WebElement addToFavoriteButton;

    @FindBy(xpath = "//*[text()='إزالة المزاد من المفضلة']")
    private WebElement deleteAddFavouriteStatement;

    @FindBy(xpath = "//*[text()='علامة المزاد المفضلة']")
    private WebElement addSuccessMessage;

    @FindBy(xpath = "/html/body/div[1]/main/section/section/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div[1]/button/span")
    private WebElement favoriteButton;

    @FindBy(xpath = "//h5[@class=\"ant-typography ant-typography-rtl css-1v0a8p9\"]")
    private List <WebElement> auctions;

    @FindBy(xpath = "//h3[text()='المزادات المفضلة']")
    private WebElement favoriteAuctionStatement;

    @FindBy(xpath = "//a[@class=\"navbar-brand m-0\"]")
    private WebElement BQLogo;

    @FindBy(xpath = "//*[text()='تم ازالة المزاد من المفضلة']")
    private WebElement deleteFromFavoriteSuccessMessage;

    @FindBy(xpath = "//*[text()='إضافة المزاد إلى المفضلة']")
    private WebElement addToFavoriteMessage;

    public void clickAddFavorite(){
        this.BQLogo.click();
       elementToBeVisible(this.searchField);
       elementToBeVisible(this.moreDetailsButton);
        this.moreDetailsButton.click();
        elementToBeVisible(this.addToFavoriteButton).click();
    }

    public WebElement getAddSuccessMessage(){
        elementToBeVisible(this.addSuccessMessage);
        return this.addSuccessMessage;
    }

    public void moveToAddFavorite(){
        Actions moveToElement=new Actions(webDriver);
        moveToElement.moveToElement(this.favoriteButton).perform();
    }

    public WebElement getMessageWhenGoToFavourite(){
        elementToBeVisible(this.deleteAddFavouriteStatement);
        return this.deleteAddFavouriteStatement;

    }

    public void goToFavoriteAssetsAndAuctions(){
        elementToBeVisible(this.searchField);
        webDriver.navigate().to("https://bq-realestate.vercel.app/#/buyer/favourite-product");
    }
     public int getTheNumberOfAuctions(){
        elementToBeVisible(this.favoriteAuctionStatement);
        return this.auctions.size();
     }

    public void goBackToFavoriteAssetsAndAuctions(){
        webDriver.navigate().to("https://bq-realestate.vercel.app/#/buyer/favourite-product");
    }

    public WebElement getDeleteFromFavoriteSuccessMessage(){
        elementToBeVisible(this.deleteFromFavoriteSuccessMessage);
        return this.deleteFromFavoriteSuccessMessage;
    }

    public WebElement getAddToFavoriteMessage(){
        elementToBeVisible(this.addToFavoriteMessage);
        return this.addToFavoriteMessage;
    }

    public void clickRemoveFromFavorite(){
        this.BQLogo.click();
        elementToBeVisible(this.searchField);
        elementToBeVisible(this.moreDetailsButton);
        this.moreDetailsButton.click();
        elementToBeVisible(this.favoriteButton).click();
    }


}



