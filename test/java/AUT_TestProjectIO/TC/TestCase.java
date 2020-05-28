package AUT_TestProjectIO.TC;


import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AUT_TestProjectIO.LoginPage;

@Listeners(testNgInterfaceImplementation.TestNgListenerUtility.class)	
public class TestCase extends TestCaseHelper{
	

	
	@Test
	public void loginWithCredentials() {
		Map<String, String> mapData = exlreader.exlMapData(1);

		driver.get(mapData.get("url"));

		LoginPage loginpage  = PageFactory.initElements(driver, LoginPage.class);
		loginpage.loginToApplication(mapData.get("UserId"), mapData.get("Password"));
	
	}
	
	@Test
	public void loginWithoutPassword() {
		Map<String, String> mapData = exlreader.exlMapData(1);

		driver.get(mapData.get("url"));

		LoginPage loginpage  = PageFactory.initElements(driver, LoginPage.class);
		loginpage.enterUserId(mapData.get("UserId"));
		loginpage.loginButton();
	
	}
	

}
