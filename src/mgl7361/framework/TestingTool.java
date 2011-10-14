package mgl7361.framework;

import java.util.ArrayList;
import java.util.List;

import mgl7361.framework.results.ResultsFileWriter;
import mgl7361.framework.results.TestCaseResult;

public class TestingTool {
	public static void main(String[] args) throws Exception {
		TestRunner testRunner = TestRunner.getInstance();
		TestSuite testSuite = new TestSuite();
		TestCaseFactory factory = new TestCaseFactory();
		List<TestCaseResult> testCaseResults = new ArrayList<TestCaseResult>();
		ResultsFileWriter resultsFileWriter = new ResultsFileWriter();
		
		for (String className : getClassNamesFromArguments(args)) {
			testSuite.add(factory.makeTestCase(className));
			testCaseResults = testRunner.execute(testSuite);
		}
		
		resultsFileWriter.WriteResultsToFile(testCaseResults);
	}
	
	private static List<String> getClassNamesFromArguments(String[] args) throws ClassNotFoundException {
		List<String> classNames = new ArrayList<String>();
		for (String className : args) {
			classNames.add(className);
		}
		return classNames;
	}
}
