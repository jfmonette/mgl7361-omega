package ca.uqam.mgl7361.a2011.omega.framework.core;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {
	private String name;
	private List<TestCase> testCases = new ArrayList<TestCase>();
	private List<TestSuite> testSuites = new ArrayList<TestSuite>();
	
	public TestSuite(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void add(TestCase testCase) {
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
