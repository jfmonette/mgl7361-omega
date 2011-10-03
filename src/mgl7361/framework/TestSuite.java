package mgl7361.framework;

import java.util.ArrayList;
import java.util.List;

class TestSuite {
	private List<Test> tests = new ArrayList<Test>();
	private List<TestCase> testCases = new ArrayList<TestCase>();
	
	protected void add(Test test) {
		tests.add(test);
	}
	
	protected void add(TestCase testCase) {
		testCases.add(testCase);
	}
	
	protected List<Test> getTests() {
		return this.tests;
	}
	
	protected List<TestCase> getTestCases() {
		return this.testCases;
	}
}
