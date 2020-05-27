package sampleProject.restApiWithJava;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TestScript2 extends TestHelper{

	int count = 0;
	
	@Test(retryAnalyzer = testNgInterfaceImplementation.TestNgRetryAnalyzerUtility.class)
	public void testScript2TestCase1() {
		count++;
		if(count < 2) {
			assertEquals(false, true);	
		}
		
		System.out.println(count);
		
		assertEquals(true, true);
	}
}
