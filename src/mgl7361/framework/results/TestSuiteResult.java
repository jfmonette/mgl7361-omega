package mgl7361.framework.results;

import java.util.ArrayList;
import java.util.List;

public class TestSuiteResult {
	private String testSuiteName;
	private List<TestCaseResult> testCaseResults = new ArrayList<TestCaseResult>();
	private List<TestSuiteResult> testSuiteResults = new ArrayList<TestSuiteResult>();

	public TestSuiteResult(String testSuiteName) {
		super();
		this.testSuiteName = testSuiteName;
	}
	
	public void add(TestCaseResult testCaseResult) {
		this.testCaseResults.add(testCaseResult);
	}
	
	public void add(TestSuiteResult testSuiteResult) {
		this.testSuiteResults.add(testSuiteResult);
	}

	public String getTestSuiteName() {
		return this.testSuiteName;
	}
	
	public List<TestCaseResult> getTestCaseResults() {
		return this.testCaseResults;
	}
	
	public List<TestSuiteResult> getTestSuiteResults() {
		return this.testSuiteResults;
	}
	
	public String toString() {
		StringBuilder testSuiteString = new StringBuilder();
		testSuiteString.append("Test suite : " + this.getTestSuiteName() + "\n");
		for (TestCaseResult testCaseResult : this.getTestCaseResults()) {
			testSuiteString.append(testCaseResult.toString());
		}
		for (TestSuiteResult testSuiteResult : this.getTestSuiteResults()) {
			testSuiteString.append(testSuiteResult.toString());
		}
		return testSuiteString.toString();
	}
	
}
