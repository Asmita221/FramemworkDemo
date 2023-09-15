package Utilities;

import Testcases.Baseclass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListnerReport implements ITestListener {
    ExtentSparkReporter html;
    ExtentReports report;
    ExtentTest test;
    Baseclass b;
    public void execute() {


        String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
        String repName = "NPTEL"+timestamp+".html";//name of report
        html =new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+ repName);			//dynamic path
        report= new ExtentReports();
        report.attachReporter(html);

        report.setSystemInfo("Machine", "Acer");
        report.setSystemInfo("OS", "Windows10");


        html.config().setTheme(Theme.DARK);
        html.config().setReportName("NPTEL Reports");
        html.config().setDocumentTitle("Report of NPTEL login");



    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(" Name of Test method  successfully executed "  +result.getName());
        test = report.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Name of passed  test method "+result.getName(), ExtentColor.GREEN));

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(" Name of Test method  Failed"  +result.getName());
        test = report.createTest(result.getName());
        test.log(Status.FAIL,MarkupHelper.createLabel("Name of failed test method "+result.getName(),ExtentColor.RED));

        b= new Baseclass();
        try {
            b.Capture_Screenshot(Baseclass.driver,result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(" Name of Test method  Skipped"  +result.getName());
        test = report.createTest(result.getName());
        test.log(Status.SKIP,MarkupHelper.createLabel("Name of passed Skipped test method "+result.getName(),ExtentColor.PINK));
    }

    @Override
    public void onStart(ITestContext context) {
        execute();

    }

    @Override
    public void onFinish(ITestContext context) {
        report.flush();

    }
}
