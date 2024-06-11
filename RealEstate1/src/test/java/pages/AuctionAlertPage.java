package pages;

import Core1.Base;
import Core1.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Core1.Base.webDriver;
import static Core1.ElementHelper.elementToBeClickable;
import static Core1.ElementHelper.elementToBeVisible;

public class AuctionAlertPage {
    public AuctionAlertPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
    @FindBy(xpath = "//*[@placeholder='أضف كلمة رئيسية']")
    private WebElement addWordField;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement addButton;

    @FindBy(xpath = "//input[@class=\"ant-input ant-input-rtl css-1v0a8p9\"]")
    private WebElement keyWord;

    @FindBy(xpath = "//button[@type=\"submit\" and @class=\"ant-btn css-1v0a8p9 ant-btn-primary ant-btn-rtl\"]")
    private WebElement confirm;

    @FindBy(xpath = "//span[text()='إلغاء']")
    private WebElement cancelButton;

    @FindBy(xpath = "//*[@data-icon=\"close\"]")
    private WebElement xButton;

    @FindBy(xpath = "//span[text()='انشاء تنبيه مزاد.']")
    private WebElement successMessageForAdd;

    @FindBy(xpath = "//span[text()='الكلمة التنبيه مضافة بالفعل']")
    private WebElement messageForAddSameWord;

    @FindBy(xpath = "//span[text()='تم حذف تنبيه المزاد بنجاح']")
    private WebElement successMessageForDelete;

    @FindBy(xpath = "//input[@placeholder=\"ابحث باستخدام الكلمات المفتاحية\"]")
    private WebElement searchField;

    @FindBy(xpath = "//h4[@class=\"ant-typography ant-typography-rtl css-1v0a8p9\"]")
    private List<WebElement> numberOfAuctionAlert;

    public void goToAuctionAlert(){
        elementToBeVisible(this.searchField);
        webDriver.navigate().to("https://bq-realestate.vercel.app/#/buyer/auction-alert");
    }

    public void addWord(String value){
        elementToBeVisible(this.addWordField).sendKeys(value);
        this.addButton.click();
    }

    public WebElement addSuccessMessage(){
        elementToBeVisible(this.successMessageForAdd);
        return this.successMessageForAdd;
    }

    public WebElement addedWord(String value){
        elementToBeVisible(webDriver.findElement(By.xpath("//*[text()='"+value+"']")));
        return webDriver.findElement(By.xpath("//h4[@class=\"ant-typography ant-typography-rtl css-1v0a8p9\"and text()='"+value+"']"));
    }

    public void testCloseButtonForEdit(String value){
        elementToBeVisible(webDriver.findElement(By.xpath("//h4[text()='"+value+"']/parent::div/following-sibling::div//*[@aria-label=\"edit\"]"))).click();
        elementToBeVisible(this.keyWord).sendKeys("text");
        this.cancelButton.click();
    }

    public WebElement oldWordAppear(String value){
        elementToBeVisible(webDriver.findElement(By.xpath("//h4[@class=\"ant-typography ant-typography-rtl css-1v0a8p9\"and text()='"+value+"']")));
        return webDriver.findElement(By.xpath("//h4[@class=\"ant-typography ant-typography-rtl css-1v0a8p9\"and text()='"+value+"']"));
    }

    public void clickCancelInTheEditPopup(String value){
        elementToBeVisible(webDriver.findElement(By.xpath("//h4[text()='"+value+"']/parent::div/following-sibling::div//*[@aria-label=\"edit\"]"))).click();
        elementToBeVisible(this.keyWord).sendKeys("text");
        this.xButton.click();
    }

    public void editTheAuctionAlert(String value, String newValue) {
        elementToBeClickable(webDriver.findElement(By.xpath("//h4[text()='"+value+"']/parent::div/following-sibling::div//*[@aria-label=\"edit\"]"))).click();
        elementToBeVisible(this.keyWord).sendKeys(Keys.chord(Keys.CONTROL,"a"));
        keyWord.sendKeys(newValue);
        confirm.click();

    }

    public WebElement editSuccessMessage(){
        elementToBeVisible(this.successMessageForAdd);
        return successMessageForAdd;
    }

    public void deleteAlert(String value){
        elementToBeVisible(webDriver.findElement(By.xpath("//h4[text()='"+value+"']/parent::div/following-sibling::div[2]//span[@aria-label=\"delete\"]"))).click();

    }

    public WebElement getSuccessMessageForDelete(){
        elementToBeVisible(this.successMessageForDelete);
        return successMessageForDelete;
    }

    public int gitNumberOfAuctionAlert(){
        elementToBeVisible(this.numberOfAuctionAlert.get(0));
        return this.numberOfAuctionAlert.size();
    }

    public WebElement alertAfterEdit(String value){
        elementToBeVisible(webDriver.findElement(By.xpath("/html/body//section[1]/section//div[3]//div[2]//div[3]//div[1]/h4[text()='"+value+"']")));
        return webDriver.findElement(By.xpath("/html/body//section[1]/section//div[3]//div[2]//div[3]//div[1]/h4[text()='"+value+"']"));
    }


}
