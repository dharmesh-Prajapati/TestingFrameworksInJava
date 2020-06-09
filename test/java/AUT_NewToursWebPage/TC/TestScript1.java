package AUT_NewToursWebPage.TC;


import java.util.Map;

import org.testng.annotations.Test;

import AUT_NewToursWebPage.HomePage;
import AUT_NewToursWebPage.RegisterPage;
import utilities.ExcelUtility;



public class TestScript1 extends BaseTestHelper {
	
	@Test
	public void loginWithCredentials() {
		exlreader = new ExcelUtility(prop.getProperty("excelPath"), prop.getProperty("excelSheetName"));
		Map<String, String> mapdata = exlreader.exlMapData(1);
		
		driver.get(prop.getProperty("url"));
		
		HomePage hmpg = new HomePage(driver);
		hmpg.registerTab();
		
		RegisterPage rgpg = new RegisterPage(driver);
		rgpg.firstName(mapdata.get("firstName"));
		rgpg.lastName(mapdata.get("lastName"));
		rgpg.phoneNum(mapdata.get("phoneNo"));
		rgpg.userName(mapdata.get("userName"));
		rgpg.userName(mapdata.get("Password"));
		rgpg.userName(mapdata.get("confirmPassword"));
		
	}

}
