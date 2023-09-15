package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    //--Webdriver Object
    WebDriver localDriver;
    public Home(WebDriver remoteDriver){
        localDriver=remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }
    //---Identifying Elements
    @FindBy(name = "submit")
    WebElement sign;

    //--performing Action
    public void sign_click(){

        sign.click();
    }
}
