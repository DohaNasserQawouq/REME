package Core1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Core1.Base.webDriver;

public class ElementHelper {

    public static final int TIME_OF_SECOND=60;
    public static WebDriverWait wait;

    public static WebElement elementToBeVisible(WebElement webElement){
        wait= new WebDriverWait(webDriver, Duration.ofSeconds(TIME_OF_SECOND));
       return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static WebElement elementToBeClickable(WebElement webElement){
        wait=new WebDriverWait(webDriver,Duration.ofSeconds(TIME_OF_SECOND));
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void scroll(){
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,500)");
    }
}
