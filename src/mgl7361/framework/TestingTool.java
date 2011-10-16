package mgl7361.framework;

import java.util.ArrayList;
import java.util.List;

import mgl7361.framework.results.ResultsFileWriter;
import mgl7361.framework.results.TestSuiteResult;

public class TestingTool {
	public static void main(String[] args) throws Exception {
		TestCaseFactory factory = TestCaseFactory.getInstance();
		TestRunner testRunner = TestRunner.getInstance();
		TestSuite testSuite = new TestSuite("Test suite #1");
		
		for (String className : getClassNamesFromArguments(args)) {
			testSuite.add(factory.makeTestCase(className));
		}
		
		ResultsFileWriter resultsFileWriter = new ResultsFileWriter();
		TestSuiteResult testSuiteResult = testRunner.execute(testSuite);
		resultsFileWriter.write(testSuiteResult);
	}
	
	private static List<String> getClassNamesFromArguments(String[] args) throws ClassNotFoundException {
		List<String> classNames = new ArrayList<String>();
		for (String className : args) {
			classNames.add(className);
		}
		return classNames;
	}
}
