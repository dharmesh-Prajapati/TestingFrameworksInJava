package restApiWithJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestScript1 extends TestHelper {


	@DataProvider
	public Iterator<Object[]> getData() {
		ArrayList<Object[]> objList = exlreader.getTestdata();
		return objList.iterator();
	}

	/*
	 * TestNg Test DataProvider Example
	 * This way it is easy for less number of data parameters.
	 * It is absurd to provide 15 20 data parameter and keep track of it
	 * 
	 * Also Gives average salary in Corporation
	 */
	@Test(dataProvider = "getData", enabled=false)
	public void testScript1TestCase1(String httpRequestType, String url) throws Exception {
		if(httpRequestType.equalsIgnoreCase("get")) {
			
		
		logger.info(httpRequestType);
 		logger.info(url);
		String responseInJson = httpConLib.getHttpResponseinJson(url, httpRequestType);
		logger.info(responseInJson);
		
		List<Map<String,String>> listOFEmploye = jsonParser.getJsonListOfMap(responseInJson, "data");
		
		int sumOfSalary = 0;
		for(int i = 0; i < listOFEmploye.size();i++) {
			sumOfSalary+=Integer.parseInt(listOFEmploye.get(i).get("employee_salary"));
		}
		logger.info("The average salary of employee in Corporation is: "+(sumOfSalary/listOFEmploye.size()));
	
		}else {
			throw new SkipException("Not for POST Metod");
		}
	}

	@Test
	public void testScript2TestCase1() {
	
		Map<String, String> mapData = exlreader.exlMapData(2);
		System.out.println();
		System.out.println();
		
		httpConLib.postHttpinJson(mapData.get("urlLink"), mapData.get("httpRequestMethod"), mapData.get("jsonInString"));
		

	}
}
