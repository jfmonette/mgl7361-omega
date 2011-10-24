package ca.uqam.mgl7361.a2011.omega.framework;

import java.util.ArrayList;
import java.util.List;

import ca.uqam.mgl7361.a2011.omega.framework.core.*;
import ca.uqam.mgl7361.a2011.omega.framework.results.*;
import ca.uqam.mgl7361.a2011.omega.framework.results.writers.*;

public class Omega {
	public static void main(String[] args) throws Exception {
		TestCaseFactory factory = TestCaseFactory.getInstance();
		TestRunner testRunner = TestRunner.getInstance();
		TestSuite testSuite = new TestSuite("TestSuite");
		
		for (String className : getClassNamesFromArguments(args)) {
			testSuite.add(factory.makeTestCase(className));
		}
		
		try {
			Writer resultsFileWriter = new TextFileWriter();
			Result testSuiteResult = testRunner.execute(testSuite);
			resultsFileWriter.write(testSuiteResult);
		}
		catch (Exception ex) {
			
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
