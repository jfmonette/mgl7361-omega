package mgl7361.framework;

import mgl7361.framework.TestSuite;

import java.util.Collection;
import java.util.LinkedList;

public class TestRunner {
	private Collection<TestSuite> testSuites = new LinkedList<TestSuite>();

	public TestRunner() {
	}
	
	public void AddTestSuite(TestSuite testSuite) {
		this.testSuites.add(testSuite);
	}
	
	public void RunTestSuites() {
		for (TestSuite testSuite : this.testSuites) {
			this.RunTestSuite(testSuite);
		}
	}
	
	private void RunTestSuite(TestSuite testSuite) {
		for (TestCase testCase : testSuite.GetTestCases()) {
			
		}
	}


}
