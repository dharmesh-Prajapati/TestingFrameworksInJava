package testNgInterfaceImplementation;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestNgRetryAnalyzerUtility implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {

		
		return false;
	}

}
