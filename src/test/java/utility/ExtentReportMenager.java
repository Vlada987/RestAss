package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportMenager implements ITestListener {
	
public ExtentSparkReporter sparkReporter;
public ExtentReports extent;
public ExtentTest test;
String repName;

public void onStart(ITestContext textContext) {
	
String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date());
repName="TestRaport"+timeStamp+".html";
sparkReporter=new ExtentSparkReporter(".\\raport\\"+repName);
sparkReporter.config().setDocumentTitle("RestA 1 report");
sparkReporter.config().setReportName("pet store API");
sparkReporter.config().setTheme(Theme.STANDARD);
extent=new ExtentReports();
extent.attachReporter(sparkReporter);
extent.setSystemInfo("Application", "booksAPI");
extent.setSystemInfo("OS",System.getProperty("os.name"));
extent.setSystemInfo("username","Zika");
extent.setSystemInfo("Enviorment","QA");
extent.setSystemInfo("user","Zikac");
}

public void onTestSuccses(ITestResult result) {
	
test=extent.createTest(result.getName());
test.assignCategory(result.getMethod().getGroups());
test.createNode(result.getName());
test.log(Status.PASS, "Test Pased");
}
public void onTestFail(ITestResult result) {
	
test=extent.createTest(result.getName());
test.createNode(result.getName());
test.assignCategory(result.getMethod().getGroups());	
test.log(Status.FAIL, "Test failed");
test.log(Status.FAIL, result.getThrowable().getMessage());
}
public void onTestSkip(ITestResult result) {
	
test=extent.createTest(result.getName());
test.createNode(result.getName());
test.assignCategory(result.getMethod().getGroups());	
test.log(Status.SKIP, "Test skipped");
test.log(Status.SKIP, result.getThrowable().getMessage());		
}
public void onFinish(ITestContext testContext) {
	
extent.flush();	
}
	
	

}
