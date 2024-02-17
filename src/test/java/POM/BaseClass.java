package POM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

public class BaseClass {

    WebDriver driver;

    PageClass pageClass;

  @Before

    public void openup(){
      WebDriverManager.firefoxdriver().setup();
      driver= new FirefoxDriver();
      driver.get("https://www.argos.co.uk/");
      pageClass =new PageClass(driver);}
    @Test
    public void search(){
      pageClass.setCookies();
      pageClass.setSearchbox("nike");
      pageClass.setSearchbutton();
      String actual= driver.findElement(By.cssSelector("[class='styles__SearchTerm-sc-1haccah-1 eslAyR']")).getText();
      Assert.assertThat(actual, Matchers.equalTo("nike"));}
  @After
  public void close(){
    driver.close();
  }



}
