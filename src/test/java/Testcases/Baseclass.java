package Testcases;

import Utilities.Configread;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Baseclass {
    Configread read = new Configread();
    String url = read.geturl();
    String browser1 = read.getbrowser();
    String accounturl = read.getcreataccounturl();
    public static WebDriver driver;

    @BeforeClass
    public void setup(){
        String browser = browser1;
        switch (browser.toLowerCase())
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("enter driver");
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void close(){
        driver.close();
    }

    public void Capture_Screenshot(WebDriver driver,String Testname) throws IOException, InterruptedException {
        String timeStamp = new SimpleDateFormat("YYYY.mm.dd.hh.mm.ss").format(new Date());
        Thread.sleep(4000);
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destfilepath = System.getProperty("user.dir")+"\\screenshots\\"+Testname+timeStamp+".png";
        FileUtils.copyFile(src,new File(destfilepath));
    }


}
