package mgl7361.framework;

import java.util.ArrayList;
import java.util.List;

class TestSuite {
	private String name;
	private List<TestCase> testCases = new ArrayList<TestCase>();
	private List<TestSuite> testSuites = new ArrayList<TestSuite>();
	
	public TestSuite(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	protected void add(TestCase testCase) {
		testCases.add(testCase);
	}
	
	protected void add(TestSuite testSuite) {
		testSuites.add(testSuite);
	}
	
	protected List<TestCase> getTestCases() {			
		return this.testCases;
	}

	protected List<TestSuite> getTestSuites() {
		return this.testSuites;
	}
	
	
}
