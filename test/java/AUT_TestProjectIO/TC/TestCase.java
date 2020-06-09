package AUT_TestProjectIO.TC;


import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import AUT_TestProjectIO.HomePage;
import AUT_TestProjectIO.LoginPage;
import testNgInterfaceImplementation.TestNgListenerUtility;

@Listeners(testNgInterfaceImplementation.TestNgListenerUtility.class)	
public class TestCase extends TestCaseHelper{
	

	
	@Test
	public void loginWithCredentials() {
		Map<String, String> mapData = exlreader.exlMapData(1);

		driver.get(mapData.get("url"));
		
		TestNgListenerUtility.test.log(Status.INFO, "Logged to url "+mapData.get("url"));
		
		LoginPage loginpage  = new LoginPage(driver);
		loginpage.loginToApplication(mapData.get("UserId"), mapData.get("Password"));
		
		HomePage homepage  = new HomePage(driver);
		assertEquals(homepage.isLogoPresent(), true);
		
		TestNgListenerUtility.test.log(Status.INFO, "Logged into application Success.");
	}
	
	@Test
	public void loginWithoutPassword() {
		Map<String, String> mapData = exlreader.exlMapData(1);

		driver.get(mapData.get("url"));

		LoginPage loginpage  = PageFactory.initElements(driver, LoginPage.class);
		loginpage.enterUserId(mapData.get("UserId"));
		loginpage.loginButton();
		assertEquals(loginpage.errorMessage(), true);
		TestNgListenerUtility.test.log(Status.INFO, "Invalid username password message");
	}
	

}
