package Testcases;

import PageObject.CreateAccount;
import PageObject.Home;
import PageObject.Login;
import Utilities.ListnerReport;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListnerReport.class)
public class Verifysignup extends Baseclass {
    @Test(priority = 1)
    public void homepage() throws InterruptedException {
        driver.get(url);
        Home home = new Home(driver);

        home.sign_click();

        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Loading...");
        Thread.sleep(4000);


        //Capture_Screenshot(driver,"homepage");
    }

    @Test(priority = 2,dependsOnMethods = "homepage")
    public void login() {
        Login log = new Login(driver);
        log.Enteruername("Asmita@2212");
        log.Enterpassword("Raut@2212");
        log.clicksignin();
    }
    @Test(priority = 3)
    public void Signup() throws InterruptedException {
        //driver.get(accounturl);
        Thread.sleep(4000);
        CreateAccount account =new CreateAccount(driver);
        account.create_Account();
        account.create_Username("Asmita@2212");
        account.create_Password("Raut@2212");
        account.setReenterpass("Raut@2212");
        account.setEmail("asmita.raut@neutrinotechlabs.com");
    }

}
