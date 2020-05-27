package testSuite1;

import static org.testng.Assert.assertEquals;

import org.testng.SkipException;
import org.testng.annotations.Test;


public class TestScript3 {

int count = 0;
	
	@Test
	public void testScript2TestCase1() {
		count++;
		if(count < 2) {
			assertEquals(false, true);	
		}
		
		System.out.println(count);
		
		assertEquals(true, true);
	}
	
	@Test
	public void testScript2TestCase2() {
		assertEquals(true, true);
	}
	
	@Test
	public void skip() {
		throw new SkipException("Skipping test Case");
	}
}
