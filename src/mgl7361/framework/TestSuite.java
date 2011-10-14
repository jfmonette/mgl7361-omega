package mgl7361.framework;

import java.util.ArrayList;
import java.util.List;

class TestSuite {
	private List<TestCase> testCases = new ArrayList<TestCase>();
	private List<TestSuite> testSuites = new ArrayList<TestSuite>();
	
	protected void add(TestCase testCase) {
		testCases.add(testCase);
	}
	
	protected void add(TestSuite testSuite) {
		testSuites.add(testSuite);
	}
	
	protected List<TestCase> getTestCases() {
		List<TestCase> allTestCases = new ArrayList<TestCase>(); 
			allTestCases.addAll(this.getInnerTestCases());
			allTestCases.addAll(this.testCases);			
		return allTestCases;
	}
	
	private List<TestCase> getInnerTestCases() {
		List<TestCase> testCases = new ArrayList<TestCase>();
		for (TestSuite testSuite : this.getTestSuites()) {
			testCases = testSuite.getTestCases();
		}	
		return testCases;
	}

	protected List<TestSuite> getTestSuites() {
		return this.testSuites;
	}
	
	
}
