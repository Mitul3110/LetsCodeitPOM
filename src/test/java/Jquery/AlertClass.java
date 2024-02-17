package Jquery;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertClass {

    WebDriver driver;

    @Before

    public void openup(){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.get("https://www.letskodeit.com/practice");}
    @Test
    public void alertclick(){
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,300)");
        WebElement box= driver.findElement(By.cssSelector("[name='enter-name']"));
        box.sendKeys("Mitul Qa");
        WebElement alert=driver.findElement(By.id("alertbtn"));
        alert.click();
        Alert alert1=driver.switchTo().alert();
        alert1.accept();}
    @After
    public void teardown(){
        driver.close();
    }
}
