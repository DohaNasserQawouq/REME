package pages;

import Core1.Base;
import Core1.ElementHelper;
import Core1.RandomData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core1.ElementHelper.elementToBeVisible;

public class LoginPage {
    public LoginPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = "//input[@name='email']/following-sibling::div[text()='هذا الحقل مطلوب']")
    private WebElement errorMessageForEmailField;

    @FindBy(xpath = "//input[@name='password']/parent::span/parent::div/div[text()='هذا الحقل مطلوب']")
    private WebElement errorMessageForPasswordField;

    @FindBy(xpath = "//div[text()='البيانات المدخله غير صحيحة']")
    private WebElement errorMessageForInvalidEmailAndMobileFormat;

    @FindBy(xpath = "//div[text()='يجب أن تتكون كلمة المرور من 5 أحرف']")
    private WebElement errorForLessThan5DigitPassword;

    @FindBy(xpath = "//div[text()='لقد أدخلت معلومات البريد إلكتروني أو رقم الجوال أو  كلمة مرور غير متطابقة.']")
    private WebElement errorMessageForIncorrectPasswordOrEmailOrMobile;

    @FindBy(xpath = "//input[@placeholder='ابحث باستخدام الكلمات المفتاحية']")
    private WebElement searchField;

    public void doNotAddTheMandatoryFields(){
       elementToBeVisible(this.email);
       this.submit.click();
    }

    public WebElement getErrorMessageForEmailField(){
        elementToBeVisible(this.errorMessageForEmailField);
        return this.errorMessageForEmailField;
    }

    public WebElement getErrorMessageForPasswordField(){
        elementToBeVisible(this.errorMessageForPasswordField);
        return this.errorMessageForPasswordField;
    }

    public void addInvalidEmailFormat(){
        elementToBeVisible(this.email);
        this.email.sendKeys("gg");
        this.password.sendKeys("123456");
        this.submit.click();
    }

    public WebElement getErrorMessageForInvalidEmailAndMobileFormat(){
        elementToBeVisible(this.errorMessageForInvalidEmailAndMobileFormat);
        return this.errorMessageForInvalidEmailAndMobileFormat;
    }

    public void addInvalidMobileFormat(){
        elementToBeVisible(this.email);
        this.email.sendKeys("051254785");
        this.password.sendKeys("123456");
        this.submit.click();
    }

    public void addLessThan5DigitPasswordNumber(){
        elementToBeVisible(this.email);
        this.email.sendKeys(RandomData.generateRandomEmail());
        this.password.sendKeys("123");
        this.submit.click();
    }

    public WebElement getErrorForLessThan5DigitPassword(){
        elementToBeVisible(this.errorForLessThan5DigitPassword);
        return this.errorForLessThan5DigitPassword;
    }

    public void addInvalidPasswordAndValidEmail(){
        elementToBeVisible(this.email);
        this.email.sendKeys("testdoha@gmail.com");
        this.password.sendKeys("125487");
        this.submit.click();
    }

    public void addInvalidEmailAndValidPassword(){
        elementToBeVisible(this.email);
        this.email.sendKeys("testdo25ha@gmail.com");
        this.password.sendKeys("123456");
        this.submit.click();
    }

    public void addInvalidMobileAndValidPassword(){
        elementToBeVisible(this.email);
        this.email.sendKeys("0548796548");
        this.password.sendKeys("123456");
        this.submit.click();
    }

    public WebElement getErrorMessageForIncorrectPasswordOrEmailOrMobile(){
        elementToBeVisible(this.errorMessageForIncorrectPasswordOrEmailOrMobile);
        return this.errorMessageForIncorrectPasswordOrEmailOrMobile;
    }

    public void addValidEmailAndValidPassword(String email, String password){
        elementToBeVisible(this.email);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.submit.click();
    }

    public WebElement getSearchFieldAfterLogin(){
        elementToBeVisible(this.searchField);
        return this.searchField;
    }

    public void addValidEMobileAndValidPassword(){
        Base.webDriver.get("https://bq-realestate.vercel.app/#/login");
        elementToBeVisible(this.email);
        this.email.sendKeys("0512452154");
        this.password.sendKeys("123456");
        this.submit.click();
    }














}
