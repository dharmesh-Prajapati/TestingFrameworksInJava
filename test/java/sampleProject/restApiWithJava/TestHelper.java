package sampleProject.restApiWithJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utilities.ExcelUtility;
import utilities.HttpConnectionUtility;
import utilities.JsonParserUtility;

public class TestHelper {
	static public Properties prop;
	public static ExcelUtility exlreader;
	public static HttpConnectionUtility testLib;
	public static JsonParserUtility jsonParser;
	
	
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
		testLib = new HttpConnectionUtility();
		jsonParser = new JsonParserUtility();
	}
	
	@AfterTest
	public void closeUp() {
		exlreader=null;
		testLib=null;
		jsonParser=null;
	}
}
