package ca.uqam.mgl7361.a2011.omega.framework.core;

import static org.junit.Assert.*;
import java.lang.reflect.Method;
import org.junit.*;
import ca.uqam.mgl7361.a2011.omega.mockproject.*;

public class TestTest {
	Method expectedSetupMethod;
	Method expectedTestMethod;
	Method expectedTeardownMethod;
	Test aTest;
	
	@Before
	public void setUp() throws SecurityException, NoSuchMethodException { 
		expectedSetupMethod = BranchTest.class.getMethod("createLeaf", null);
		expectedTestMethod = BranchTest.class.getMethod("AddingLeavesToABranch", null);
		expectedTeardownMethod = BranchTest.class.getMethod("destroyLeaf", null);
		aTest = new Test(expectedSetupMethod, expectedTestMethod, expectedTeardownMethod);
	}
	
	@org.junit.Test
	public void testGetSetupMethod() {
		String expectedSetupMethodName = expectedSetupMethod.getName();
		String resultSetupMethodName = aTest.getSetupMethod().getName();
		assertTrue(expectedSetupMethodName.equals(resultSetupMethodName));
	}
	
	@org.junit.Test
	public void testGetTestMethod() {
		String expectedTestMethodName = expectedTestMethod.getName();
		String resultTestMethodName = aTest.getTestMethod().getName();
		assertTrue(expectedTestMethodName.equals(resultTestMethodName));
	}

	@org.junit.Test
	public void testGetTeardownMethod() {
		String expectedTeardownMethodName = expectedTeardownMethod.getName();
		String resultTeardownMethodName = aTest.getTearDownMethod().getName();
		assertTrue(expectedTeardownMethodName.equals(resultTeardownMethodName));
	}
	
	@After
	public void tearDown() throws SecurityException, NoSuchMethodException { 
		expectedSetupMethod = null;
		expectedTestMethod = null;
		expectedTeardownMethod = null;
		aTest = null;
	}

}
