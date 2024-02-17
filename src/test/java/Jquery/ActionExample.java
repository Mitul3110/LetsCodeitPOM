package Jquery;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionExample {

    WebDriver driver;


    @Before
    public void openup(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://www.letskodeit.com/practice");

    }
    @Test
    public void Topclick() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        WebElement hover=driver.findElement(By.cssSelector("#mousehover"));
        Actions act = new Actions(driver);
        act.moveToElement(hover).build().perform();
        Thread.sleep(15000);
        WebElement topclick= driver.findElement(By.xpath("//div[@class='mouse-hover-content']/a"));
        topclick.click();}
    @After
    public void teardown(){
        driver.quit();
    }
}
