package testNgInterfaceImplementation;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testSuite1.TestHelper;

public class TestNgListenerUtility implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		TestHelper.logger.info("Test Case "+result.getTestName()+" started.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

}
