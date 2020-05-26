package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

public class TestHelper {
	static public Properties prop;
	public static ExcelUtility exlreader;
	
	public TestHelper() {

		prop = new Properties();
		String fileName = "C:\\Users\\Dharmesh\\Documents\\Projects\\utilites\\config.properties";
		InputStream is = null;
		try {
			is = new FileInputStream(fileName);
			prop.load(is);
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		}
	}
	
	@BeforeTest
	public void setUp() {
		exlreader = new ExcelUtility(prop.getProperty("excelPath"), prop.getProperty("excelSheetName"));
	}
}
