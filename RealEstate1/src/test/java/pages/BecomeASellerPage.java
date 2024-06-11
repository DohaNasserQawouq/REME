package pages;

import Core1.Base;
import Core1.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static Core1.Base.webDriver;
import static Core1.ElementHelper.elementToBeVisible;

public class BecomeASellerPage {
    public BecomeASellerPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
    @FindBy(xpath = "//input[@placeholder=\"ابحث باستخدام الكلمات المفتاحية\"]")
    private WebElement searchField;

    @FindBy(name = "name")
    private WebElement nameField;

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement descriptionField;

    @FindBy(xpath = "//*[@placeholder=\"اختيار التاريخ\"]")
    private WebElement fallEndDate;

    @FindBy(xpath = "//td[@title=\"2024-02-13\"]//div[@class=\"ant-picker-cell-inner\" and text()=\"13\"]")
    private WebElement selectDate;

    @FindBy(name = "falNumber")
    private WebElement fallNumberField;

    @FindBy(xpath = "//div[@class=\"ant-upload ant-upload-select\"]//input[@type=\"file\"]")
    private WebElement imageField;

    @FindBy(name = "primaryCell")
    private WebElement phoneNumber1Field;

    @FindBy(name = "secondaryCell")
    private WebElement getPhoneNumber2Field;

    @FindBy(name = "whatsappCell")
    private WebElement whatsappNumberField;

    @FindBy(xpath = "//span[@aria-label=\"inbox\"]")
    private WebElement addAttachment;

    @FindBy(xpath = "//span[text()='اعتماد']")
    private WebElement confirmButton;

    @FindBy(xpath = "//input[@name='name']/parent::div/following-sibling::div//span[text()='هذا الحقل مطلوب']")
    private WebElement thisFieldIsRequiredMessageForNameField;

    @FindBy(xpath = "//*[@name='description']/parent::div/following-sibling::div//span[text()='هذا الحقل مطلوب']")
    private WebElement thisFieldIsRequiredMessageForDescriptionField;

    @FindBy(xpath = "//*[@placeholder=\"اختيار التاريخ\"]/parent::div/parent::div/parent::div/following-sibling::div//span[text()='هذا الحقل مطلوب']")
    private WebElement thisFieldIsRequiredMessageForFallExpiryDateField;

    @FindBy(xpath = "//*[@name=\"falNumber\"]/parent::div/following-sibling::div//span[text()='هذا الحقل مطلوب']")
    private WebElement thisFieldIsRequiredMessageForFallNumberField;

    @FindBy(xpath = "//*[text()='الشعار']/parent::div/following-sibling::div//span[text()='هذا الحقل مطلوب']")
    private WebElement thisFieldIsRequiredMessageForAddImage;

    @FindBy(xpath = "//*[@name=\"primaryCell\"]/parent::span/parent::div/following-sibling::div//span[text()='هذا الحقل مطلوب']")
    private WebElement thisFieldIsRequiredMessageForPhoneNumber1Field;

    @FindBy(xpath = "//*[text()='تنسيق رقم الجوال المدخل غير صحيح']")
    private WebElement messageForIncorrectPhoneNumber;

    @FindBy(xpath = "//*[text()='مكتملة بنجاح']")
    private WebElement messageForSucees;

    @FindBy(css = ".ant-picker-cell:not(.ant-picker-cell-disabled):not(.ant-picker-cell-today)")
    private List<WebElement> availableDate;

    @FindBy(css = "[placeholder=\"اختيار التاريخ\"]")
    private WebElement selectDateFromList;


    public void goToBecomeASeller() throws InterruptedException {
        elementToBeVisible(this.searchField);
        Base.webDriver.navigate().to("https://bq-realestate.vercel.app/#/seller-register");
    }

    public void checkTheRequiredFields() throws InterruptedException {
        elementToBeVisible(this.nameField);
        this.confirmButton.click();

    }

    public WebElement getThisFieldIsRequiredMessageForNameField(){
        elementToBeVisible(this.thisFieldIsRequiredMessageForNameField);
        return this.thisFieldIsRequiredMessageForNameField;
    }

    public WebElement getThisFieldIsRequiredMessageForDescriptionField(){
        return this.thisFieldIsRequiredMessageForDescriptionField;
    }

    public WebElement getThisFieldIsRequiredMessageForPhoneNumber1Field(){
        return this.thisFieldIsRequiredMessageForPhoneNumber1Field;
    }

    public WebElement getThisFieldIsRequiredMessageForFallExpiryDateField(){
        return this.thisFieldIsRequiredMessageForFallExpiryDateField;
    }

    public WebElement getThisFieldIsRequiredMessageForFallNumberField(){
        return this.thisFieldIsRequiredMessageForFallNumberField;
    }

    public WebElement getThisFieldIsRequiredMessageForAddImage(){
        return this.thisFieldIsRequiredMessageForAddImage;
    }

    public void addLessThan10DigitInFirstPhoneNum() throws InterruptedException {
        elementToBeVisible(this.nameField);
        this.nameField.sendKeys("test one");
        elementToBeVisible(this.descriptionField);
        this.descriptionField.sendKeys("test");
        this.fallNumberField.sendKeys("254");
        this.selectDateFromList.click();
        elementToBeVisible(this.availableDate.get(1)).click();
        this.imageField.sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\testFiles\\images.jpg");
        this.phoneNumber1Field.sendKeys("12345");
        this.confirmButton.click();

    }

    public void addLessThan10DigitInSecondPhoneNum() {
        elementToBeVisible(this.nameField);
        this.nameField.sendKeys("test one");
        elementToBeVisible(this.descriptionField);
        this.descriptionField.sendKeys("test");
        this.fallNumberField.sendKeys("254");
        this.selectDateFromList.click();
        elementToBeVisible(this.availableDate.get(5)).click();
        this.imageField.sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\testFiles\\صور-سيارات-جاكوار-الرياضية-7.jpg");
        this.getPhoneNumber2Field.sendKeys("12547");
        this.phoneNumber1Field.sendKeys("1234567894");
        this.confirmButton.click();
    }
    public void addLessThan10DigitInWhatAppNum() {
        elementToBeVisible(this.nameField);
        this.nameField.sendKeys("test one");
        elementToBeVisible(this.descriptionField);
        this.descriptionField.sendKeys("test");
        this.fallNumberField.sendKeys("254");
       this.selectDateFromList.click();
       elementToBeVisible(this.availableDate.get(5)).click();
        this.imageField.sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\testFiles\\images.jpg");
        this.phoneNumber1Field.sendKeys("1234567894");
        this.whatsappNumberField.sendKeys("1235");
        this.confirmButton.click();
    }

    public void addValidDataInAllFields() {
        elementToBeVisible(this.nameField);
        this.nameField.sendKeys("test one");
        elementToBeVisible(this.descriptionField);
        this.descriptionField.sendKeys("test");
        this.fallNumberField.sendKeys("254");
        this.selectDateFromList.click();
        elementToBeVisible(this.availableDate.get(6)).click();
        this.imageField.sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\testFiles\\صور-سيارات-جاكوار-الرياضية-7.jpg");
        this.phoneNumber1Field.sendKeys("1234567894");
        this.whatsappNumberField.sendKeys("123567895");
        this.confirmButton.click();
    }

    public WebElement gitErrorMessageForAddIncorrectPhoneNumber(){
        elementToBeVisible(this.messageForIncorrectPhoneNumber);
        return this.messageForIncorrectPhoneNumber;
    }

    public WebElement gitSuccessMessage(){
        elementToBeVisible(this.messageForSucees);
        return this.messageForSucees;
    }



}
