package POM1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    WebDriver driver;

    PageClass pageClass;

    @Before
    public void openup(){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        pageClass= new PageClass(driver);
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MICROSECONDS);
    }

    @Test
    public void letKodeit(){
        pageClass.setSelectbox();
        pageClass.setMulti();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        pageClass.setEnable("Mitul");

    }
    @After
    public  void teardown(){
        driver.quit();
    }
}
