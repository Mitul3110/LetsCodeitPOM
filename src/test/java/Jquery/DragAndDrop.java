package Jquery;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

    WebDriver driver;

    @Before

    public void openup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://jqueryui.com/droppable/");}

    @Test

    public void droppable() throws InterruptedException {

        WebElement iframe= driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(iframe);
        WebElement dragitem= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropitem= driver.findElement(By.cssSelector("[id='droppable']"));
        Actions action =new Actions(driver);
        action.dragAndDrop(dragitem,dropitem).build().perform();
        String actual= dragitem.getText();
        Assert.assertThat(actual, Matchers.equalTo("Dropped!"));
        Thread.sleep(15000);
    }

    @After
    public void tear (){
        driver.close();}

}
