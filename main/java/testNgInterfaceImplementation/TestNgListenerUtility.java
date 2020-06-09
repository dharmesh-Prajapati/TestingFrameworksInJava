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

import restApiWithJava.TestHelper;

public class TestNgListenerUtility implements ITestListener{


	static Date d = new Date();
	// path to save generated extent report with date.
	static String fileName = "Extent_" + d.toString().replace(":", "_") + ".html";

	static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
	public static ExtentTest test;  
	// Thread safe instance with ExtentTest Generic to provide multiple Testcases execute parallely.
	public static ThreadLocal<ExtentTest> testReports = new ThreadLocal<ExtentTest>();


	/*
	 * OnTestStart test is created with Testcase name.
	 * @see org.testng.ITestListener#onTestStart(org.testng.ITestResult)
	 */
	@Override
	public void onTestStart(ITestResult result) {

		TestHelper.logger.info("Test Case "+result.getTestClass().getName()+" "+result.getMethod().getMethodName()+" started.");

		test  = extent.createTest(result.getTestClass().getName()+" @TestCase: "+result.getMethod().getMethodName());
		testReports.set(test);
		test.log(Status.INFO, "Test Case "+result.getTestClass().getName()+" "+result.getMethod().getMethodName()+" started.");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String logText = "<b>Test Method "+result.getMethod().getMethodName().toUpperCase()+" SUCCESSFUL</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReports.get().log(Status.PASS, m);
		test.log(Status.INFO, "Test Case Finished.");
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
		test.log(Status.INFO, "Test Case Finished.");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String logText = "<b>Test Method "+result.getMethod().getMethodName()+" SKIPPED</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReports.get().log(Status.SKIP, m);
		test.log(Status.INFO, "Test Case Finished.");
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
		
		if(extent != null) {
			extent.flush();	
		}

	}

}
