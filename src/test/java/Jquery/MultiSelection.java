package Jquery;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiSelection {


    WebDriver driver;

    @Before
    public void openup(){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.get("https://www.letskodeit.com/practice");}
    @Test
    public void multisel(){
        WebElement multi= driver.findElement(By.id("multiple-select-example"));
        Select sel= new Select(multi);
        sel.selectByValue("apple");
        sel.selectByVisibleText("Orange");
        sel.selectByIndex(1);
        sel.deselectAll();
        List<WebElement> selection=sel.getOptions();
        int size=selection.size();
        System.out.println(size);}
    @After
    public void teardown(){
        driver.close();
    }
}
