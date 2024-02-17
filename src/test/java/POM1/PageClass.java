package POM1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class PageClass {

    WebDriver driver;

@FindBy (id = "carselect")
   private WebElement Selectbox;
@FindBy (css = "#multiple-select-example")
    private WebElement multi;
@FindBy(xpath = "//input[@id='enabled-button']")
    private WebElement enable;
@FindBy(id = "enabled-example-input")
private WebElement enablebox;


public PageClass(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver,this);
}
public void setSelectbox(){
    Selectbox.click();
    Select select =new Select(Selectbox);
    select.selectByIndex(2);
}

    public void setMulti() {
        Select sel = new Select(multi);
        sel.selectByValue("orange");
        List<WebElement> selection = sel.getOptions();
        int size = selection.size();
        System.out.println("The size is" + size);}
     public  void setEnable(String name){
    enable.click();
    enablebox.click();
    enablebox.sendKeys(name);
     }




    }
