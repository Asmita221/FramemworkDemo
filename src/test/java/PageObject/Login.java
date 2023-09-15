package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver localDriver;
    public Login(WebDriver remoteDriver){
        localDriver=remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }

    //---Identifying Elements
    @FindBy(name = "Username or email address")
    WebElement Username;
    @FindBy(id = "password")
    WebElement Password;
    @FindBy(id = "next")
    WebElement Sign_in;



    //--performing Actions
    public void Enteruername(String Name){

        Username.sendKeys(Name);
    }
    public void Enterpassword(String pass){

        Password.sendKeys(pass);
    }
    public void clicksignin(){
        Sign_in.click();
    }


}