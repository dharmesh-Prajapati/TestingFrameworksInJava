package AUT_NewToursWebPage.TC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import utilities.ExcelUtility;

public class BaseTestHelper {

	WebDriver driver;
	static public Properties prop;
	public static ExcelUtility exlreader;

	public static Logger logger = LogManager.getLogger(BaseTestHelper.class);


	/*
	 *  BaseTestHelper class helps all the test script classes with pre requisites.
	 */
	public BaseTestHelper() {

		prop = new Properties();
		String fileName = "C:\\Users\\Dharmesh\\Documents\\Projects\\utilites\\mercuryTourconfig.properties";
		InputStream is = null;
		try {
			is = new FileInputStream(fileName);
			prop.load(is);
		} catch (FileNotFoundException ex) {
			logger.error("FileNotFoundExceptoin while loading properties file in TestHelper constructor");
		} catch (IOException ex) {
			logger.error("IOExceptoin while loading properties file in TestHelper constructor");
		}
	}

	/*
	 * Before Test creates a static reference to the object needing in Test Execution.
	 */

	@BeforeMethod
	public void setUpBeforeMethod() {
		driver = getDriverInstance(prop.getProperty("browser"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDownAfterMethod() {
		driver.quit();
	}


	/*
	 * After Test all static references made to point null after test execution to let Garbage collector do its work.
	 */
	@AfterTest
	public void closeUp() {
		exlreader=null;
	}


	/*
	 * returns instance of Webdriver for respective browser
	 */
	public WebDriver getDriverInstance(String browserName) {

		switch(browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverExe"));
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", prop.getProperty("geckoDriverExe"));
			driver = new FirefoxDriver();
			break;
		}
		
		return driver;
	}
}
