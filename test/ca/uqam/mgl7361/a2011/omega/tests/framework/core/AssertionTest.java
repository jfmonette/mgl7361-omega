package ca.uqam.mgl7361.a2011.omega.tests.framework.core;

import static org.junit.Assert.*;

import org.junit.Test;
import ca.uqam.mgl7361.a2011.omega.framework.core.Assertion;

public class AssertionTest {

	@Test
	public void testIdenticalObjects() {
		boolean testWasSuccessful;
		
		try {
			Assertion.AssertExpectedEqualsActual("abc", "abc");
			testWasSuccessful =  true;
		} catch (AssertionError ex) {
			testWasSuccessful = false;
		}
		assertTrue(testWasSuccessful);
	}
	
	@Test
	public void testNonIdenticalObjects() {
		boolean testWasSuccessful;
		
		try {
			Assertion.AssertExpectedEqualsActual("abc", "abcd");
			testWasSuccessful =  false;
		} catch (AssertionError ex) {
			testWasSuccessful = true;
		}
		assertTrue(testWasSuccessful);
	}

}
