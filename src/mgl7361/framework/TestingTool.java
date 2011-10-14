package mgl7361.framework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import mgl7361.framework.results.TestCaseResult;

public class TestingTool {
	public static void main(String[] args) throws Exception {
		TestRunner testRunner = TestRunner.getInstance();
		TestSuite testSuite = new TestSuite();
		TestCaseFactory factory = new TestCaseFactory();
		List<TestCaseResult> testCaseResults = new ArrayList<TestCaseResult>();
		
		for (String className : getClassNamesFromArguments(args)) {
			testSuite.add(factory.makeTestCase(className));
			testCaseResults = testRunner.execute(testSuite);
		}
		
		for (TestCaseResult testCaseResult : testCaseResults) {
			try {
				FileWriter fstream = new FileWriter("results.txt");
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("Passed: " + testCaseResult.getNumberOfPassedTests() + " Failed: " + testCaseResult.getNumberOfFailedTests());
				out.close();
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}
	
	private static List<String> getClassNamesFromArguments(String[] args) throws ClassNotFoundException {
		List<String> classNames = new ArrayList<String>();
		for (String className : args) {
			classNames.add(className);
		}
		return classNames;
	}
}
