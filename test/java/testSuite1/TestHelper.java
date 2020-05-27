package testSuite1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utilities.ExcelUtility;
import utilities.HttpConnectionUtility;
import utilities.JsonParserUtility;

public class TestHelper {
	static public Properties prop;
	public static ExcelUtility exlreader;
	public static HttpConnectionUtility httpConLib;
	public static JsonParserUtility jsonParser;
	
	public static Logger logger = LogManager.getLogger(TestHelper.class);
	
	public TestHelper() {

		logger.info("Loading properties file in TestHelper constructor");
		prop = new Properties();
		String fileName = "C:\\Users\\Dharmesh\\Documents\\Projects\\utilites\\config.properties";
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
	
	@BeforeTest
	public void setUp() {
		exlreader = new ExcelUtility(prop.getProperty("excelPath"), prop.getProperty("excelSheetName"));
		httpConLib = new HttpConnectionUtility();
		jsonParser = new JsonParserUtility();
	}
	
	@AfterTest
	public void closeUp() {
		exlreader=null;
		httpConLib=null;
		jsonParser=null;
	}
}
