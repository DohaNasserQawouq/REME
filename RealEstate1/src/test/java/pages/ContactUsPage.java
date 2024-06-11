package pages;

import Core1.ElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core1.ElementHelper.elementToBeVisible;

public class ContactUsPage {
    public ContactUsPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
    @FindBy(xpath = "//a[text()='اتصل بنا']")
    private WebElement goToContactUs;

    @FindBy(name = "name")
    private WebElement name;

    @FindBy(name = "cell")
    private WebElement cell;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "message")
    private WebElement yourMessage;

    @FindBy(xpath = "//span[text()='إرسال']")
    private WebElement submit;

    @FindBy(xpath = "//span[text()='الاسم']/parent::div/following-sibling::div[2]/span[text()='هذا الحقل مطلوب']")
    private WebElement errorMessageForName;

    @FindBy(xpath = "//span[text()='رقم الخلوي']/parent::div/following-sibling::div[2]/span[text()='هذا الحقل مطلوب']")
    private WebElement errorMessageForCell;

    @FindBy(xpath = "//span[text()='عنوان البريد الالكترونى']/parent::div/following-sibling::div[2]/span[text()='هذا الحقل مطلوب']")
    private WebElement errorMessageForEmail;

    @FindBy(xpath = "//span[text()='رسالتك']/parent::div/following-sibling::div[2]/span[text()='هذا الحقل مطلوب']")
    private WebElement errorMessageForYourMessage;

    @FindBy(xpath = "//span[text()='البيانات المدخله غير صحيحة']")
    private WebElement errorMessageForInvalidEmailFormat;

    @FindBy(xpath = "//span[text()='تنسيق رقم الجوال المدخل غير صحيح']")
    private WebElement errorMessageForInvalidCellNumberFormat;

    @FindBy(xpath = "//span[text()='تم حفظ الرسالة بنجاح']")
    private WebElement successMessage;

    public void doNotAddTheMandatoryFields(){
        elementToBeVisible(this.goToContactUs);
        this.goToContactUs.click();
        elementToBeVisible(this.name);
        this.submit.click();
    }

    public WebElement getErrorMessageForName(){
        elementToBeVisible(this.errorMessageForName);
        return this.errorMessageForName;
    }

    public WebElement getErrorMessageForEmail(){
        elementToBeVisible(this.errorMessageForEmail);
        return this.errorMessageForEmail;
    }

    public WebElement getErrorMessageForCell(){
        elementToBeVisible(this.errorMessageForCell);
        return this.errorMessageForCell;
    }

    public WebElement getErrorMessageForYourMessage(){
        elementToBeVisible(this.errorMessageForYourMessage);
        return this.errorMessageForYourMessage;
    }

    public void addIncorrectCellNumber(){
        elementToBeVisible(this.goToContactUs);
        this.goToContactUs.click();
        elementToBeVisible(this.name);
        this.name.sendKeys("test");
        this.cell.sendKeys("12345");
        this.email.sendKeys("test@gmail.com");
        this.yourMessage.sendKeys("testing");
        this.submit.click();
    }

    public WebElement getErrorMessageForInvalidCellNumberFormat(){
        elementToBeVisible(this.errorMessageForInvalidCellNumberFormat);
        return this.errorMessageForInvalidCellNumberFormat;
    }

    public void addInvalidEmailFormat(){
        elementToBeVisible(this.goToContactUs);
        this.goToContactUs.click();
        elementToBeVisible(this.name);
        this.name.sendKeys("test");
        this.cell.sendKeys("12345678");
        this.email.sendKeys("test");
        this.yourMessage.sendKeys("testing");
        this.submit.click();}

    public WebElement getErrorMessageForInvalidEmailFormat(){
        elementToBeVisible(this.errorMessageForInvalidEmailFormat);
        return this.errorMessageForInvalidEmailFormat;
    }

    public void addValidData(){
        elementToBeVisible(this.goToContactUs);
        this.goToContactUs.click();
        elementToBeVisible(this.name);
        this.name.sendKeys("test");
        this.cell.sendKeys("12345678");
        this.email.sendKeys("test@gmail.com");
        this.yourMessage.sendKeys("testing");
        this.submit.click();
    }

    public WebElement getSuccessMessage(){
        elementToBeVisible(this.successMessage);
        return this.successMessage;
    }
}
