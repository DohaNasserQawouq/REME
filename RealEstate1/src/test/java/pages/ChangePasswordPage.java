package pages;

import Core1.Base;
import Core1.ElementHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.lang.model.element.Element;

import static Core1.Base.webDriver;
import static Core1.ElementHelper.elementToBeVisible;

public class ChangePasswordPage {
    public ChangePasswordPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(name = "currentPassword")
    private WebElement currentPassword;

    @FindBy(name = "password")
    private WebElement newPassword;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//span[text()='تغيير كلمة المرور']")
    private WebElement changePasswordButton;

    @FindBy(xpath = "//input[@name=\"currentPassword\"]/parent::span/parent::div//following-sibling::div//span[text()='هذا الحقل مطلوب']")
    private WebElement messageForCurrentPasswordAsAMandatory;

    @FindBy(xpath = "//input[@name=\"password\"]/parent::span/parent::div//following-sibling::div//span[text()='هذا الحقل مطلوب']")
    private WebElement messageForNewPasswordAsAMandatory;

    @FindBy(xpath = "//input[@name=\"confirmPassword\"]/parent::span/parent::div//following-sibling::div//span[text()='هذا الحقل مطلوب']")
    private WebElement messageForConfirmPasswordAsAMandatory;

    @FindBy(xpath = "//span[text()='كلمة المرور القديمة غير صحيحة']")
    private WebElement messageForIncorrectCurrentPassword;

    @FindBy(xpath = "//span[text()='يجب أن يكون الطول 5 أحرف على الأقل']")
    private WebElement messageForAddLessThan5DigitInPasswordField;

    @FindBy(xpath = "//span[text()='تأكيد كلمة المرور غير متطابقة مع كلمة المرور الجديدة']")
    private WebElement messageWhenThePasswordDoesNotMatchConfirmPassword;

    @FindBy(xpath = "//span[text()='لا تستخدم كلمة مرور قديمة! الرجاء اختيار كلمة مرور جديدة']")
    private WebElement messageWhenTheOldPasswordMatchNewPassword;

    @FindBy(xpath = "//*[text()='شكرا لك! تم تغيير كلمة المرور الخاصة بك بنجاح']")
    private WebElement successMessageForChangePassword;

    @FindBy(css = "[placeholder=\"ابحث باستخدام الكلمات المفتاحية\"]")
    private WebElement searchField;


    public void goToPersonalInfo(){
        elementToBeVisible(this.searchField);
        webDriver.navigate().to("https://bq-realestate.vercel.app/#/profile");
    }

    public void checkMandatoryFields(){
        elementToBeVisible(this.currentPassword);
        this.changePasswordButton.click();
    }

    public WebElement getMessageForCurrentPasswordAsAMandatory(){
        elementToBeVisible(this.messageForCurrentPasswordAsAMandatory);
        return  this.messageForCurrentPasswordAsAMandatory;
    }

    public WebElement getMessageForNewPasswordAsAMandatory(){
        elementToBeVisible(this.messageForNewPasswordAsAMandatory);
        return this.messageForNewPasswordAsAMandatory;
    }

    public WebElement getMessageForConfirmPasswordAsAMandatory(){
        elementToBeVisible(this.messageForConfirmPasswordAsAMandatory);
        return this.messageForConfirmPasswordAsAMandatory;
    }

    public void addIncorrectCurrentPassword(){
        elementToBeVisible(this.currentPassword);
        this.currentPassword.sendKeys("5588963");
        this.newPassword.sendKeys("556644");
        this.confirmPassword.sendKeys("556644");
        this.changePasswordButton.click();
    }

    public WebElement getMessageForIncorrectCurrentPassword(){
        elementToBeVisible(this.messageForIncorrectCurrentPassword);
        return this.messageForIncorrectCurrentPassword;
    }

    public void addLessThan5DigitsInTheNewPasswordField(){
        elementToBeVisible(this.currentPassword);
        this.currentPassword.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.currentPassword.sendKeys("123456");
        this.newPassword.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.newPassword.sendKeys("1234");
        this.confirmPassword.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.confirmPassword.sendKeys("1234");
        this.changePasswordButton.click();
    }

    public WebElement getMessageForAddLessThan5DigitInPasswordField(){
        elementToBeVisible(this.messageForAddLessThan5DigitInPasswordField);
        return this.messageForAddLessThan5DigitInPasswordField;
    }

    public void addNewPasswordSameToPreviousPassword(){
        elementToBeVisible(this.currentPassword);
        this.newPassword.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.newPassword.sendKeys("123456");
        this.confirmPassword.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.confirmPassword.sendKeys("123456");
        this.changePasswordButton.click();
    }

    public WebElement getMessageWhenTheOldPasswordMatchNewPassword(){
        elementToBeVisible(this.messageWhenTheOldPasswordMatchNewPassword);
        return this.messageWhenTheOldPasswordMatchNewPassword;
    }

    public void addConfirmPasswordDoesNotMatchNewPassword(){
        elementToBeVisible(this.currentPassword);
        this.newPassword.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.newPassword.sendKeys("12345");
        this.confirmPassword.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.confirmPassword.sendKeys("52862");
    }

    public WebElement getMessageWhenThePasswordDoesNotMatchConfirmPassword(){
        elementToBeVisible(this.messageWhenThePasswordDoesNotMatchConfirmPassword);
        return this.messageWhenThePasswordDoesNotMatchConfirmPassword;
    }

    public void changeTheCurrentPassword(){
        elementToBeVisible(this.currentPassword);
        this.currentPassword.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.currentPassword.sendKeys("123456");
        this.newPassword.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.newPassword.sendKeys("12345");
        this.confirmPassword.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        this.confirmPassword.sendKeys("12345");
        this.changePasswordButton.click();
    }

    public WebElement getSuccessMessageForChangePassword(){
        elementToBeVisible(this.successMessageForChangePassword);
        return this.successMessageForChangePassword;
    }


}
