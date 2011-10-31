package ca.uqam.mgl7361.a2011.omega.framework.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ca.uqam.mgl7361.a2011.omega.framework.results.Result;

public class TestTestRunner {
	private TestSuite testSuite;
	private String outputFileName = "testResults";
	private String testClassName = "BranchTest";
	
	@Before
	public void setup() {
		testSuite = new TestSuite(outputFileName);
		TestCaseFactory factory = TestCaseFactory.getInstance();
		try {
			testSuite.add(factory.makeTestCase(testClassName));
		} catch (ClassNotFoundException e) {
			System.out.print("Unable to find a class named '" + testClassName + "'");
		}
	}
	
	@Test
	public void testExecuteTestSuite() {
		TestRunner testRunner = TestRunner.getInstance();
		Result testSuiteResult = testRunner.execute(testSuite);
		assertTrue(testSuiteResult.getName() == testClassName);
		assertTrue(testSuiteResult.getNumberOfSuccessfullTests() == 1);
		assertTrue(testSuiteResult.getNumberOfFailedTests() == 0);
	}
}
