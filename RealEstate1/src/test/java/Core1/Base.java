package Core1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
    public static WebDriver webDriver;
    @BeforeClass
    public static void setUp(){
        webDriver= new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://bq-realestate.vercel.app/#/login");
    }

    /*@AfterClass
    public static void close(){
        webDriver.quit();
    }*/
}
