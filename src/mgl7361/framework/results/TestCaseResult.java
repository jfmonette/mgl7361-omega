package mgl7361.framework.results;

import java.util.ArrayList;
import java.util.List;

public class TestCaseResult {
	private String TestCaseName;
	private List<TestResult> testResults = new ArrayList<TestResult>();

	public TestCaseResult(String testCaseName) {
		super();
		this.TestCaseName = testCaseName;
	}
	
	public void addTestResult(TestResult testResult) {
		this.testResults.add(testResult);
	}

	public String getTestCaseName() {
		return TestCaseName;
	}
	
	public int getNumberOfPassedTests() {
		int numberOfPassedTests = 0;
		for (TestResult testResult : this.getTestResults()) {
			if (testResult.isPassed()) numberOfPassedTests++;
		}
		return numberOfPassedTests;	
	}
	
	public int getNumberOfFailedTests() {
		int numberOfFailedTests = 0;
		for (TestResult testResult : this.getTestResults()) {
			if (!testResult.isPassed()) numberOfFailedTests++;
		}
		return numberOfFailedTests;
		
	}
	
	public List<TestResult> getTestResults() {
		return testResults;
	}
	
	public String toString() {
		StringBuilder testCaseString = new StringBuilder();
		testCaseString.append("Test Case : " + this.getTestCaseName() + " ");
		testCaseString.append("Passed : " + this.getNumberOfPassedTests() + " ");
		testCaseString.append("Failed : " + this.getNumberOfFailedTests());
		return testCaseString.toString();
	}
}
