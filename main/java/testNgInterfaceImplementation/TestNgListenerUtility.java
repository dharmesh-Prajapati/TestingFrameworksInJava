package testNgInterfaceImplementation;

import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import testSuite1.TestHelper;

public class TestNgListenerUtility implements ITestListener{

	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_") + ".html";

	static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
	public static ThreadLocal<ExtentTest> testReports = new ThreadLocal<ExtentTest>();


	@Override
	public void onTestStart(ITestResult result) {

		TestHelper.logger.info("Test Case "+result.getTestClass().getName()+" "+result.getMethod().getMethodName()+" started.");

		ExtentTest test  = extent.createTest(result.getTestClass().getName()+" @TestCase: "+result.getMethod().getMethodName());
		testReports.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String logText = "<b>Test Method "+result.getMethod().getMethodName().toUpperCase()+" SUCCESSFUL</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReports.get().log(Status.PASS, m);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());

		testReports.get().fail("<details><summary><b><font color=red>"+	
				"Exception Occured, click to see details:"+ "</font></b></summary>"+
				exceptionMessage.replaceAll(",", "<br>")+"</details> \n");

		String logText = "<b>Test Method "+ methodName +" failed</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		testReports.get().log(Status.FAIL,m);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String logText = "<b>Test Method "+result.getMethod().getMethodName()+" SKIPPED</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReports.get().log(Status.SKIP, m);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {

		TestHelper.logger.info("Test Case "+context.getName()+" ended.");
		extent.flush();
	}

}
