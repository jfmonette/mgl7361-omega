package mgl7361.framework;

import java.util.ArrayList;
import java.util.List;

public class TestingTool {
	public static void main(String[] args) throws Exception {
		TestRunner testRunner = TestRunner.getInstance();
		TestSuite testSuite = new TestSuite();
		TestCaseFactory factory = new TestCaseFactory();
		
		for (String className : getClassNamesFromArguments(args)) {
			testSuite.add(factory.makeTestCase(className));
			testRunner.execute(testSuite);
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
