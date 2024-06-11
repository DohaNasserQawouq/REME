package pages;

import Core1.Base;
import Core1.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core1.Base.webDriver;
import static Core1.ElementHelper.elementToBeVisible;

public class WalletPage {

    public WalletPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
    @FindBy(xpath = "//span[text()='إضافة اشتراكات']")
    private WebElement addSubscriptionButton;

    @FindBy(xpath = "//input[@role=\"spinbutton\"]")
    private WebElement amount;

    @FindBy(xpath = "//*[@data-icon=\"inbox\"]")
    private WebElement approvePayment;

    @FindBy(xpath = "//*[text()='تأكيد']")
    private  WebElement submit;

    @FindBy(xpath = "//*[text()='إلغاء']")
    private  WebElement cancel;

    @FindBy(xpath = "//*[@data-icon=\"close\"]")
    private WebElement close;

    @FindBy(xpath = "//*[text()='لا يمكن أن يكون أقل من واحد']")
    private WebElement errorMessageForAmountField;

    @FindBy(xpath = "//*[text()='هذا الحقل مطلوب']")
    private WebElement errorMessageForApprovePayment;

    @FindBy(xpath = "//*[@placeholder=\"ابحث باستخدام الكلمات المفتاحية\"]")
    private WebElement searchField;

    @FindBy(xpath = "//*[text()='تم ارسال طلب اضافة اشتراك للموافقة عليه']")
    private WebElement addSubscriptionSucessMessage;

    @FindBy(xpath = "//div[@data-node-key=\"orders\"]/div[text()='الطلبات']")
    private WebElement orderSection;

    @FindBy(xpath = "//div[@class=\"ant-collapse ant-collapse-icon-position-start ant-collapse-rtl ant-collapse-ghost css-1v0a8p9\"]//div[2]//span[@class=\"ant-collapse-header-text\"]")
    private WebElement subscribtionMenu;

    @FindBy(xpath = "//span//input[@type=\"file\"]")
    private WebElement addFile;

    public void goToWallet(){
        elementToBeVisible(this.searchField);
      webDriver.get("https://bq-realestate.vercel.app/#/buyer/re-wallet");
    }

    public void doNotAddMandatoryFields(){
        elementToBeVisible(this.addSubscriptionButton);
        this.addSubscriptionButton.click();
        elementToBeVisible(this.submit);
        this.submit.click();
    }
    public WebElement getErrorMessageForAmountField(){
        elementToBeVisible(this.errorMessageForAmountField);
        return  this.errorMessageForAmountField;
    }

    public WebElement getErrorMessageForApprovePayment(){
        elementToBeVisible(this.errorMessageForApprovePayment);
        return this.errorMessageForApprovePayment;
    }
    public void clickCancelForAddSubscriptionPopup(){
        elementToBeVisible(this.addSubscriptionButton);
        this.addSubscriptionButton.click();
        elementToBeVisible(this.amount);
        this.cancel.click();
    }

    public void clickCloseForAddSubscriptionPopup(){
        elementToBeVisible(this.addSubscriptionButton);
        this.addSubscriptionButton.click();
        elementToBeVisible(this.amount);
        this.close.click();
    }

    public String getHtmlBody(){
        return webDriver.getPageSource();
    }

    public void addSubscribtion(String amount) throws InterruptedException {
        elementToBeVisible(this.addSubscriptionButton);
        this.addSubscriptionButton.click();
        elementToBeVisible(this.amount);
        this.amount.sendKeys(amount);
        //this.approvePayment.sendKeys("C:\\Users\\Nextwo\\Desktop\\صور-سيارات-جاكوار-الرياضية-7.jpg");
        this.addFile.sendKeys("C:\\Users\\Nextwo\\Desktop\\صور-سيارات-جاكوار-الرياضية-7.jpg");
        this.submit.click();
        /*String mainWindowHandle = webDriver.getWindowHandle();
        for (String windowHandle : webDriver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                webDriver.switchTo().window(windowHandle);
                break;
            }
        }
        webDriver.switchTo().window(mainWindowHandle);

        WebElement cancelButton = webDriver.findElement(By.xpath("//*[contains(text(), 'Cancel')]"));
        cancelButton.click();
        */


    }
    public WebElement gitAddSubscriptionSucessMessage(){
        elementToBeVisible(this.addSubscriptionSucessMessage);
        return this.addSubscriptionSucessMessage;
    }

    public WebElement checkTheAddedAmount(String amount){
        elementToBeVisible(this.orderSection);
        this.orderSection.click();
        this.subscribtionMenu.click();
        elementToBeVisible(webDriver.findElement(By.xpath("//div[ text()='"+amount+"']")));
        return webDriver.findElement(By.xpath("//div[ text()='"+amount+"']"));
    }

}
