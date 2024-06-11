package pages;

import Core1.ElementHelper;
import Core1.RandomData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core1.ElementHelper.elementToBeVisible;

public class SignUpPage {
    public SignUpPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/header/div/nav/ul[1]/li[2]/a")
    private WebElement userIcon;

    @FindBy(linkText = "انشاء حساب جديد")
    private WebElement createNewAccount;

    @FindBy(name = "name")
    private WebElement name;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "cell")
    private WebElement cellNumber;

    @FindBy(name="agree")
    private  WebElement rulesAndConditionsCheckBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registerButton;

    @FindBy(linkText = "تسجيل الدخول")
    private WebElement logIn;

    @FindBy(xpath = "//*[text()='البريد الإلكتروني المسجل موجود بالفعل']")
    private WebElement errorMessageForExistEmail;

    @FindBy(xpath = "//*[text()='رقم جوالك مسجل عندنا من قبل']")
    private WebElement errorMessageForExistMobileNumber;

    @FindBy(xpath = "//*[text()='يجب أن تتكون كلمة المرور من 5 أحرف']")
    private WebElement errorMessageForIncorrectPassword;

    @FindBy(xpath = "//span[@class=\"ant-typography ant-typography-rtl ant-typography-danger css-1v0a8p9\"]")
    private WebElement conditionsAndTermsSentence;

    @FindBy(xpath = "//*[text()='البيانات المدخله غير صحيحة']")
    private WebElement errorMessageForInvalidEmail;

    @FindBy(xpath = "//input[@name='name']/parent::div/following-sibling::div/span[text()='هذا الحقل مطلوب']")
    private WebElement errorForNameField;

    @FindBy(xpath = "//input[@name='email']/parent::div/following-sibling::div/span[text()='هذا الحقل مطلوب']")
    private WebElement errorForEmailField;

    @FindBy(xpath = "//input[@name='password']/parent::span/parent::div/following-sibling::div/span[text()='هذا الحقل مطلوب']")
    private WebElement errorForPasswordField;

    @FindBy(xpath = "//input[@name='cell']/parent::span/parent::div/following-sibling::div/span[text()='هذا الحقل مطلوب']")
    private WebElement errorForCellField;

    @FindBy(xpath = "//h2[text()='تأكيد الحساب']")
    private WebElement confirmAccount;


    public void goToSignUp(){
        //elementToBeVisible(this.userIcon);
        //this.userIcon.click();
        elementToBeVisible(this.createNewAccount);
        this.createNewAccount.click();

    }

    public void goToLogin(){
        elementToBeVisible(this.logIn);
        this.logIn.click();
    }
    public WebElement getLoginPage(){
        ElementHelper.elementToBeVisible(this.createNewAccount);
        return this.createNewAccount;
    }

    public void SignUpWithExistEmail(){
        elementToBeVisible(this.name);
        this.name.sendKeys("test name");
        this.email.sendKeys("testdoha@gmail.com");
        this.password.sendKeys("123456");
        this.cellNumber.sendKeys(RandomData.generateRandomPhoneNumber());
        this.rulesAndConditionsCheckBox.click();
        this.registerButton.click();
    }

    public WebElement errorMessageForExistEmail(){
        elementToBeVisible(this.errorMessageForExistEmail);
        return this.errorMessageForExistEmail;
    }

    public void signUpWithExistMobileNumber(){
        elementToBeVisible(this.name);
        this.name.sendKeys("test name");
        this.email.sendKeys(RandomData.generateRandomEmail());
        this.cellNumber.sendKeys("22587666");
        this.password.sendKeys("123456");
        this.rulesAndConditionsCheckBox.click();
        this.registerButton.click();
    }
    public WebElement getErrorMessageForExistMobileNumber(){
        elementToBeVisible(this.errorMessageForExistMobileNumber);
        return this.errorMessageForExistMobileNumber;
    }

    public void signUpWithIncorrectPassword(){
        elementToBeVisible(this.name);
        this.name.sendKeys("test name");
        this.email.sendKeys(RandomData.generateRandomEmail());
        this.password.sendKeys("1234");
        this.cellNumber.sendKeys(RandomData.generateRandomPhoneNumber());
        this.rulesAndConditionsCheckBox.click();
        this.registerButton.click();
    }
    public WebElement getErrorMessageForIncorrectPassword(){
        elementToBeVisible(this.errorMessageForIncorrectPassword);
        return this.errorMessageForIncorrectPassword;
    }

    public void signUPWithoutCheckTheCheckbox(){
        elementToBeVisible(this.name);
        this.name.sendKeys("test name");
        this.email.sendKeys(RandomData.generateRandomEmail());
        this.password.sendKeys("12345");
        this.cellNumber.sendKeys(RandomData.generateRandomPhoneNumber());
        this.registerButton.click();
    }

    public String getColorForConditionSentence(){
        elementToBeVisible(this.conditionsAndTermsSentence);
        return this.conditionsAndTermsSentence.getCssValue("color");
    }
    public void signupWithInvalidEmail(){
        elementToBeVisible(this.name);
        this.name.sendKeys("test");
        this.email.sendKeys("test");
        this.password.sendKeys("123456");
        this.cellNumber.sendKeys("22554425");
        this.rulesAndConditionsCheckBox.click();
        this.registerButton.click();
    }

    public WebElement getErrorMessageForInvalidEmail(){
        elementToBeVisible(this.errorMessageForInvalidEmail);
        return this.errorMessageForInvalidEmail;
    }

    public void doNotAddAnyValueInTheRequiredField(){
        elementToBeVisible(this.name);
        this.registerButton.click();
    }
    public WebElement getErrorMessageForNameField(){
        elementToBeVisible(this.errorForNameField);
        return errorForNameField;
    }
    public WebElement getErrorMessageForEmailField(){
        return this.errorForEmailField;
    }
    public WebElement getErrorMessageForCellField(){
        return this.errorForCellField;
    }
    public WebElement getErrorMessageForPasswordField(){
        return this.errorForPasswordField;
    }
    public void signupWithValidData(){
        elementToBeVisible(this.name);
        this.name.sendKeys("testing");
        this.password.sendKeys(RandomData.generateRandomPassword());
        this.cellNumber.sendKeys(RandomData.generateRandomPhoneNumber());
        this.email.sendKeys(RandomData.generateRandomEmail());
        this.rulesAndConditionsCheckBox.click();
        this.registerButton.click();
    }

    public WebElement getConfirmAccount(){
        elementToBeVisible(this.confirmAccount);
        return this.confirmAccount;
    }



}
