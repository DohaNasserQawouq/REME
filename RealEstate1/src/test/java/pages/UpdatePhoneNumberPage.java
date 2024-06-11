package pages;

import Core1.Base;
import Core1.ElementHelper;
import Core1.RandomData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core1.Base.webDriver;
import static Core1.ElementHelper.elementToBeClickable;
import static Core1.ElementHelper.elementToBeVisible;

public class UpdatePhoneNumberPage {
    public UpdatePhoneNumberPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(name = "cell")
    private WebElement phoneNumber;

    @FindBy(xpath = "//*[text()='رقم التحديث']")
    private WebElement updateButton;

    @FindBy(xpath = "//*[@aria-label=\"close-circle\"]")
    private WebElement xButton;

    @FindBy(xpath = "//div[text()='رقم جوالك مسجل عندنا من قبل']")
    private WebElement messageForAddExistPhoneNumber;


    @FindBy(xpath ="//div[text()='تنسيق رقم الجوال المدخل غير صحيح']")
    private WebElement messageForAddIncorrectPhoneNumber;

    @FindBy(xpath = "//div[text()='رقم الجوال مطلوب. ']")
    private WebElement messageForCheckPhoneNumberAsAMandatoryField;

    @FindBy(xpath = "//*[@data-icon=\"close\"]")
    private WebElement closeButton;

    @FindBy(css = "[form=\"otp-form\"]")
    private WebElement submitButton;

    @FindBy(xpath = "//span[text()='أعد إرسال رمز التأكيد']")
    private WebElement resubmitVerificationCode;

    @FindBy(xpath = "//*[text()='تأكدنا من رقم جوالك ']")
    private WebElement successMessageForUpdatePhoneNumber;

    @FindBy(css = "[aria-label=\"Digit 4\"]")
    private WebElement confirmationCode;

    @FindBy(xpath = "//div[text()='المعذرة! رمز التحقق الي ادخلته خاطئ.']")
    private WebElement messageForAddIncorrectCode;

    @FindBy(xpath = "//div[text()='رمز التحقق مطلوب. ']")
    private WebElement messageForDidNotAddCode;

    @FindBy(xpath = "//div[text()='حبينا نبشرك ارسلنا لك رمز التحقق جديد تحقق من الرسائل النصية']")
    private WebElement successMessageForResendVerificationCode;

    @FindBy(css = "[placeholder=\"ابحث باستخدام الكلمات المفتاحية\"]")
    private WebElement searchFieldInHome;

    @FindBy(xpath = "//button[text()='حسنا']")
    private WebElement okWord;

    public void goToPersonalInformationScreen(){
        elementToBeVisible(this.searchFieldInHome);
        webDriver.navigate().to("https://bq-realestate.vercel.app/#/profile");
    }

    public void addExistMobileNumber(){
        elementToBeVisible(this.phoneNumber);
        this.updateButton.click();

    }

    public WebElement getMessageForAddExistPhoneNumber(){
        elementToBeVisible(this.messageForAddExistPhoneNumber);
        return messageForAddExistPhoneNumber;
    }

    public  void AddIncorrectPhoneNumber(){
        elementToBeVisible(this.phoneNumber);
        this.phoneNumber.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.phoneNumber.sendKeys("512345");
        this.updateButton.click();
    }

    public WebElement getMessageForAddIncorrectPhoneNumber(){
        elementToBeVisible(this.messageForAddIncorrectPhoneNumber);
        return this.messageForAddIncorrectPhoneNumber;
    }

    public void doNotAddAnyValueInThePhoneField(){
        elementToBeVisible(this.phoneNumber);
        this.xButton.click();
        this.updateButton.click();
    }

    public WebElement getMessageForCheckPhoneNumberAsAMandatoryField(){
        elementToBeVisible(this.messageForCheckPhoneNumberAsAMandatoryField);
        return messageForCheckPhoneNumberAsAMandatoryField;
    }

    public void testAddNewCorrectPhoneNumber(){
        elementToBeVisible(this.phoneNumber);
        this.phoneNumber.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        phoneNumber.sendKeys("05");
        phoneNumber.sendKeys(RandomData.generateRandomPhoneNumber());
        this.updateButton.click();

    }

    public WebElement goToCertificateCode(){
        elementToBeVisible(this.confirmationCode);
        return this.confirmationCode;
    }

    public void checkCodeFieldIsMandatory(){
        elementToBeVisible(this.confirmationCode);
        this.submitButton.click();
        elementToBeVisible(this.okWord);
        this.closeButton.click();
    }

    public WebElement getMessageForDidNotAddCode(){
        elementToBeVisible(this.messageForDidNotAddCode);
        return messageForDidNotAddCode;
    }

    public void addWrongVerificationCode(){
        elementToBeVisible(this.confirmationCode).sendKeys("123");
        this.submitButton.click();
        elementToBeVisible(this.okWord);
        this.closeButton.click();
    }

    public WebElement getMessageForAddIncorrectCode(){
        elementToBeVisible(this.messageForAddIncorrectCode);
        return this.messageForAddIncorrectCode;
    }

    public void resubmitVerificationCode(){
        elementToBeVisible(this.confirmationCode);
        this.resubmitVerificationCode.click();
        elementToBeVisible(this.okWord);
        this.closeButton.click();
    }

    public WebElement getSuccessMessageForResendVerificationCode(){
        elementToBeVisible(this.successMessageForResendVerificationCode);
        return this.successMessageForResendVerificationCode;
    }

    public void addCorrectCode(){
        elementToBeVisible(this.confirmationCode);
        this.confirmationCode.sendKeys("1234");
        this.submitButton.click();
        elementToBeVisible(this.okWord);
    }

    public WebElement getSuccessMessageForUpdatePhoneNumber(){
        elementToBeVisible(this.successMessageForUpdatePhoneNumber);
        return this.successMessageForUpdatePhoneNumber;
    }
}
