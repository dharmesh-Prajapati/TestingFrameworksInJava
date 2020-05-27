package testNgInterfaceImplementation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports createInstance(String fileName) {
		
		System.out.println(fileName);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Learning Extent Report", "Demo");
		extent.setSystemInfo("Browser", "chrome");
		extent.setSystemInfo("Author", "Dharmesh");
		
		return extent;
	}

}
