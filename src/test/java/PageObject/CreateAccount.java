package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
    WebDriver localDriver;
    public CreateAccount(WebDriver remoteDriver){
        localDriver=remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }

    @FindBy(linkText = "Sign up now")
    WebElement signup;
    @FindBy(id = "UserId")
    WebElement enterusername;
    @FindBy(id = "newPassword")
    WebElement enterpassword;
    @FindBy(id = "reenterPassword")
    WebElement reenterpass;
    @FindBy(id ="email")
    WebElement Email;
    @FindBy(id = "email_ver_but_send")
    WebElement Verify;


    public void create_Account(){
        signup.click();
    }
    public void create_Username(String name){
        enterusername.sendKeys(name);
    }
    public void create_Password(String password){
        enterpassword.sendKeys(password);
    }
    public void setReenterpass(String password){
        reenterpass.sendKeys(password);
    }
    public void setEmail(String email){
        Email.sendKeys(email);

    }
    public void chcekverifiy(){
        Verify.click();
    }




}
