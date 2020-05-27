package testSuite1;

import java.util.ArrayList;
import java.util.Iterator;

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
	 */
	@Test(dataProvider = "getData")
	public void testScript1TestCase1(String httpRequestType, String url) throws Exception {
 		logger.info(httpRequestType);
 		logger.info(url);
		String responseInJson = httpConLib.getHttpResponseinJson(url);
		logger.info(responseInJson);
	}


	@Test
	public void testScript2TestCase1() throws Exception {
		

	}
}
