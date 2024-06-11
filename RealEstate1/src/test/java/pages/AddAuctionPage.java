package pages;

import Core1.Base;
import Core1.ElementHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core1.Base.webDriver;
import static Core1.ElementHelper.elementToBeVisible;

public class AddAuctionPage {
    public AddAuctionPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(name = "name")
    private WebElement name;

    @FindBy(css = "[class=\"ant-input css-1v0a8p9\"]")
    private WebElement description;

    @FindBy(css = "[placeholder=\"اختيار التاريخ\"]")
    private  WebElement startDate;

    @FindBy(css = "[class=\"ant-select-selection-item\"]")
    private WebElement startTime;

    @FindBy(xpath = "//span[@class=\"ant-upload\"]/input[@type=\"file\" and @style=\"display: none;\"]")
    private WebElement addImage;

    @FindBy(name = "phoneNumber")
    private WebElement phoneNumber;

    @FindBy(name = "whatsappNumber")
    private WebElement whatsappNumber;

    @FindBy(xpath = "//span[@class=\"ant-typography ant-typography-rtl css-1v0a8p9\"]")
    private WebElement addDocuments;

    @FindBy(xpath = "//button[@form=\"create-auction-form\"]")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@name='name']/parent::div/following-sibling::div/span[text()='هذا الحقل مطلوب']")
    private WebElement mandatoryMessageForNameField;

    @FindBy(xpath = "//textarea[@name='description']/parent::div/following-sibling::div/span[text()='هذا الحقل مطلوب']")
    private WebElement mandatoryMessageForDescriptionField;

    @FindBy(xpath = "//span[text()='صورة']/parent::div/following-sibling::div/span[text()='هذا الحقل مطلوب']")
    private WebElement mandatoryMessageForImageField;

    @FindBy(xpath = "//input[@name=\"phoneNumber\"]/parent::span/parent::div/following-sibling::div/span[text()='هذا الحقل مطلوب']")
    private WebElement mandatoryMessageForPhoneNumberField;

    @FindBy(xpath = "//span[text()='يجب أن يكون تاريخ البدء في المستقبل']")
    private WebElement messageForIncorrectStartDate;

    @FindBy(css = "[placeholder=\"ابحث باستخدام الكلمات المفتاحية\"]")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class=\"ant-btn css-1v0a8p9 ant-btn-circle ant-btn-default ant-btn-icon-only ant-btn-background-ghost ant-btn-rtl\"]//*[@class=\"feather feather-eye\"]")
    private WebElement viewPicture;

    @FindBy(xpath = "//div[@class=\"ant-modal-content\"]//*[@alt=\"preview image\"]")
    private WebElement theImage;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/button/span")
    private WebElement closeImage;

    @FindBy(xpath = "//*[@class=\"feather feather-trash-2\"]")
    private WebElement deleteThePicture;

    @FindBy(xpath = "//*[text()='تنسيق رقم الجوال المدخل غير صحيح']")
    private WebElement messageForIncorrectMobileNumber;

    @FindBy(xpath = "//*[text()='رقم الواتس اب ليس بالصيغة الصحيحة']")
    private WebElement messageForIncorrectWhatsappNumber;

    public void goToAddAuction(){
        elementToBeVisible(this.searchField);
       webDriver.get("https://bq-realestate.vercel.app/#/re-auction");
    }

    public void doNotAddTheMandatoryFields(){
        elementToBeVisible(this.name);
        this.nextButton.click();
    }

    public WebElement getMandatoryMessageForNameField(){
        elementToBeVisible(this.mandatoryMessageForNameField);
        return this.mandatoryMessageForNameField;
    }

    public WebElement getMandatoryMessageForDescriptionField(){
        elementToBeVisible(this.mandatoryMessageForDescriptionField);
        return this.mandatoryMessageForDescriptionField;
    }

    public WebElement getMandatoryMessageForImageField(){
        elementToBeVisible(this.mandatoryMessageForImageField);
        return this.mandatoryMessageForImageField;
    }

    public WebElement getMandatoryMessageForPhoneNumberField(){
        elementToBeVisible(this.mandatoryMessageForPhoneNumberField);
        return this.mandatoryMessageForPhoneNumberField;
    }

    public void viewTheAddedImage(){
        ElementHelper.scroll();
        this.addImage.sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\testFiles\\صور-سيارات-جاكوار-الرياضية-7.jpg");
        this.viewPicture.click();

    }

    public WebElement thePictureAppear(){
        elementToBeVisible(this.theImage);
        return this.theImage;
    }

    public void closeTheImage(){
        this.closeImage.click();
    }

    public void deleteThePicture(){
        this.deleteThePicture.click();
        this.nextButton.click();
    }

    public void addInvalidPhoneNumber(){
        webDriver.navigate().refresh();
        elementToBeVisible(this.name);
        this.name.sendKeys("test name");
        elementToBeVisible(this.description);
        this.description.sendKeys("test description");
        this.addImage.sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\testFiles\\صور-سيارات-جاكوار-الرياضية-7.jpg");
        this.phoneNumber.sendKeys("45698");
        this.nextButton.click();
    }

    public WebElement getMessageForIncorrectMobileNumber(){
        elementToBeVisible(this.messageForIncorrectMobileNumber);
        return  this.messageForIncorrectMobileNumber;
    }

    public void addIncorrectWhatsappNumber(){
        this.phoneNumber.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.phoneNumber.sendKeys("123456789");
        this.whatsappNumber.sendKeys("12345");
        this.nextButton.click();
    }

    public WebElement getMessageForIncorrectWhatsappNumber(){
        elementToBeVisible(this.messageForIncorrectWhatsappNumber);
        return this.messageForIncorrectWhatsappNumber;
    }
}
