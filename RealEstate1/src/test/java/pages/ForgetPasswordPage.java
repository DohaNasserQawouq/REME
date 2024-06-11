package pages;

import Core1.ElementHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core1.ElementHelper.elementToBeVisible;

public class ForgetPasswordPage {
    public ForgetPasswordPage(WebDriver webDriver){

        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//*[text()='هل نسيت كلمة المرور؟']")
    private WebElement forgetPasswordLink;

    @FindBy(xpath = "//*[text()='إلغاء']")
    private WebElement cancelButton;

    @FindBy(xpath = "//*[@data-icon='close']")
    private WebElement XButton;

    @FindBy(name = "cell")
    private WebElement cellNumber;

    @FindBy(xpath = "//*[text()='تأكيد']")
    private WebElement confirm;

    @FindBy(xpath = "//*[text()='رقم الجوال مطلوب. ']")
    private WebElement errorWhenYouDidNotAddMobile;

    @FindBy(xpath = "//*[text()='تنسيق رقم الجوال المدخل غير صحيح']")
    private WebElement errorForInvalidMobileFormat;

    @FindBy(xpath = "//*[text()='عذرا ، ليس لدينا ملف تعريف مسجل في تلك الخلية']")
    private WebElement getErrorForInvalidMobile;

    @FindBy(xpath = "//input[@aria-label='Please enter verification code. Digit 1']")
    private WebElement digit1InTheVerificationCode;

    @FindBy(xpath = "//input[@aria-label='Digit 2']")
    private WebElement digit2InTheVerificationCode;

    @FindBy(xpath = "//input[@aria-label='Digit 3']")
    private WebElement digit3InTheVerificationCode;

    @FindBy(xpath = "//input[@aria-label='Digit 4']")
    private WebElement digit4InTheVerificationCode;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswprd;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = "//span[text()='أرخل رمز التأكيد']/parent::div/following-sibling::div[2]/span[text()='هذا الحقل مطلوب']")
    private WebElement errorMessageForAddOTP;

    @FindBy(xpath = "//input[@placeholder='ادخل كلمة المرور']/parent::span/parent::div/following-sibling::div[1]/span[text()='هذا الحقل مطلوب']")
    private WebElement errorMessageForPassword;

    @FindBy(xpath = "//input[@placeholder='تأكيد كلمة المرور غير متطابق']/parent::span/parent::div/following-sibling::div[1]/span[text()='هذا الحقل مطلوب']")
    private WebElement errorMessageForConfirmPassword;

    @FindBy(xpath = "//div[text()='كلمة المرور الجديدة يجب أن تكون على الأقل 5 أحرف بطول. ']")
    private WebElement errorMessageForAddLessThan5DigitsForNewPassword;

    @FindBy(xpath = "//div[text()='تأكيد كلمة المرور غير متطابق كلمة المرور الجديدة']")
    private WebElement errorMessageWhenConfirmPasswordDoesNotMatchPassword;

    @FindBy(xpath = "//div[text()='المعذرة! رمز التحقق الي ادخلته خاطئ.']")
    private WebElement errorMessageForIncorrectOTP;

    @FindBy(xpath = "//div[text()='لا تستخدم كلمة مرور قديمة! الرجاء اختيار كلمة مرور جديدة']")
    private WebElement errorMessageForUseOldPassword;

    @FindBy(xpath = "//span[text()='تم تغيير كلمة المرور بنجاح.']")
    private WebElement sucessMessage;



    public void goToForgetPassword(){
        elementToBeVisible(this.forgetPasswordLink);
        this.forgetPasswordLink.click();
    }

    public void clickCancelForForgetPasswordPopup(){
        elementToBeVisible(this.cellNumber);
        this.cancelButton.click();
    }

    public void clickXForForgetPasswordPopup(){
        elementToBeVisible(this.cellNumber);
        this.XButton.click();
    }
    public void doNotAddAnyNumber(){
        elementToBeVisible(this.cellNumber);
        this.confirm.click();
    }
    public void AddInvalidMobileFormat(){
        elementToBeVisible(this.cellNumber);
        this.cellNumber.sendKeys("12654");
        this.confirm.click();
    }

    public void AddInvalidMobile(){
        elementToBeVisible(this.cellNumber);
        this.cellNumber.sendKeys("54888888");
        this.confirm.click();
    }

    public WebElement getForgetPasswordPopup(){
        return this.cellNumber;
    }

    public WebElement getErrorWhenYouDidNotAddMobile(){
        elementToBeVisible(this.errorWhenYouDidNotAddMobile);
        return this.errorWhenYouDidNotAddMobile;
    }

    public WebElement getErrorForInvalidMobileFormat(){
        elementToBeVisible(this.errorForInvalidMobileFormat);
        return this.errorForInvalidMobileFormat;
    }
    public WebElement getGetErrorForInvalidMobile(){
        elementToBeVisible(this.getErrorForInvalidMobile);
        return this.getErrorForInvalidMobile;
    }
    public void addValidMobileNumber(){
        elementToBeVisible(this.cellNumber);
        this.cellNumber.sendKeys("12452154");
        this.confirm.click();
    }

    public WebElement getResetPasswordPage(){
        elementToBeVisible(this.digit1InTheVerificationCode);
        return this.digit1InTheVerificationCode;
    }

    public void doNotAddAnyFieldAndClickSubmit(){
        elementToBeVisible(this.digit1InTheVerificationCode);
        this.submit.click();
    }
    public WebElement getErrorMessageForAddOTP(){
        elementToBeVisible(this.errorMessageForAddOTP);
        return this.errorMessageForAddOTP;
    }

    public WebElement getErrorMessageForPassword(){
        elementToBeVisible(this.errorMessageForPassword);
        return this.errorMessageForPassword;
    }

    public WebElement getErrorMessageForConfirmPassword(){
        elementToBeVisible(this.errorMessageForConfirmPassword);
        return this.errorMessageForConfirmPassword;
    }

    public void addIncorrectOTP(){
        elementToBeVisible(this.digit1InTheVerificationCode);
        this.digit1InTheVerificationCode.sendKeys("1");
        this.digit2InTheVerificationCode.sendKeys("3");
        this.digit3InTheVerificationCode.sendKeys("5");
        this.digit4InTheVerificationCode.sendKeys("6");
        this.password.sendKeys("12345");
        this.confirmPasswprd.sendKeys("12345");
        this.submit.click();
    }

    public WebElement getErrorMessageForIncorrectOTP(){
        elementToBeVisible(this.errorMessageForIncorrectOTP);
        return this.errorMessageForIncorrectOTP;
    }

    public void addLessThan5DigitPaasword(){
        elementToBeVisible(this.digit1InTheVerificationCode);
        this.digit1InTheVerificationCode.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.digit1InTheVerificationCode.sendKeys("1");
        this.digit2InTheVerificationCode.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.digit2InTheVerificationCode.sendKeys("2");
        this.digit3InTheVerificationCode.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.digit3InTheVerificationCode.sendKeys("3");
        this.digit4InTheVerificationCode.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.digit4InTheVerificationCode.sendKeys("4");
        this.password.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.password.sendKeys("123");
        this.confirmPasswprd.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.confirmPasswprd.sendKeys("123");
        this.submit.click();
    }

    public WebElement getErrorMessageForAddLessThan5DigitsForNewPassword(){
        elementToBeVisible(this.errorMessageForAddLessThan5DigitsForNewPassword);
        return this.errorMessageForAddLessThan5DigitsForNewPassword;
    }

    public void newPasswordDoesNotMatchConfirmPassword(){
        elementToBeVisible(this.digit1InTheVerificationCode);
        this.digit1InTheVerificationCode.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.digit1InTheVerificationCode.sendKeys("1");
        this.digit2InTheVerificationCode.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.digit2InTheVerificationCode.sendKeys("2");
        this.digit3InTheVerificationCode.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.digit3InTheVerificationCode.sendKeys("3");
        this.digit4InTheVerificationCode.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.digit4InTheVerificationCode.sendKeys("4");
        this.password.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.password.sendKeys("12345");
        this.confirmPasswprd.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.confirmPasswprd.sendKeys("123555");
        this.submit.click();
    }

    public WebElement getErrorMessageWhenConfirmPasswordDoesNotMatchPassword(){
        elementToBeVisible(this.errorMessageWhenConfirmPasswordDoesNotMatchPassword);
        return this.errorMessageWhenConfirmPasswordDoesNotMatchPassword;
    }

    public void addPasswordSameToOldOne(){
        elementToBeVisible(this.digit1InTheVerificationCode);
        this.digit1InTheVerificationCode.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.digit1InTheVerificationCode.sendKeys("1");
        this.digit2InTheVerificationCode.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.digit2InTheVerificationCode.sendKeys("2");
        this.digit3InTheVerificationCode.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.digit3InTheVerificationCode.sendKeys("3");
        this.digit4InTheVerificationCode.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.digit4InTheVerificationCode.sendKeys("4");
        this.password.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.password.sendKeys("123456");
        this.confirmPasswprd.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.confirmPasswprd.sendKeys("123456");
        this.submit.click();
    }

    public WebElement getErrorMessageForUseOldPassword(){
        elementToBeVisible(this.errorMessageForUseOldPassword);
        return this.errorMessageForUseOldPassword;
    }

    public void addValidData(){
        elementToBeVisible(this.digit1InTheVerificationCode);
        this.digit1InTheVerificationCode.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.digit1InTheVerificationCode.sendKeys("1");
        this.digit2InTheVerificationCode.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.digit2InTheVerificationCode.sendKeys("2");
        this.digit3InTheVerificationCode.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.digit3InTheVerificationCode.sendKeys("3");
        this.digit4InTheVerificationCode.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.digit4InTheVerificationCode.sendKeys("4");
        this.password.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.password.sendKeys("12345");
        this.confirmPasswprd.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.confirmPasswprd.sendKeys("12345");
        this.submit.click();
    }

    public WebElement getSucessMessage(){
        elementToBeVisible(this.sucessMessage);
        return this.sucessMessage;
    }


}
