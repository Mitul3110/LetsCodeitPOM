package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageClass {
    WebDriver driver;

    @FindBy(css = "button[id='consent_prompt_submit']")
    WebElement cookies;
    @FindBy(xpath = "//input[@id='searchTerm']")
    WebElement searchbox;
    @FindBy(css = "button[class='_2mKaC']")
    WebElement searchbutton;
    @FindBy(css = "div[data-el='search-title'] :nth-child(2)")
    WebElement niketext;

  public PageClass(WebDriver driver){
      this.driver= driver;
      PageFactory.initElements(driver,this);}

   public void setCookies(){cookies.click();}
    public void setSearchbox(String product){searchbox.sendKeys(product);}
    public void setSearchbutton(){searchbutton.click();}
    public String  setNiketext(){return niketext.getText();}
}
