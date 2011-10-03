package mgl7361.framework;

import java.lang.reflect.Method;
import java.util.List;

class TestRunner {
	private static int numberOfPassedTests = 0, numberOfFailedTests = 0;
	
	private TestRunner() { }
	
	private static class SingletonHolder { 
        public static final TestRunner instance = new TestRunner();
	}
	
	public static TestRunner getInstance() {
        return SingletonHolder.instance;
	}
	
	public void execute(TestSuite testSuite){
		this.executeTests(testSuite.getTests());
		this.executeTestCases(testSuite.getTestCases());
		this.printResults();
	}
	
	private void executeTests(List<Test> tests) {
		for (Test test : tests) {
			this.executeTest(test);
		}
	}

	private void executeTest(Test test) {
		this.executeWithoutLogging(test.getSetupMethod());
		this.executeWithLogging(test.getTestMethod());
		this.executeWithoutLogging(test.getTearDownMethod());	
	}

	private void executeWithLogging(Method method) {
		try {
			method.invoke(null);
            numberOfPassedTests++;
         } catch (Throwable ex) {
            numberOfFailedTests++;
         }
	}

	private void executeWithoutLogging(Method method) {
		try {
			method.invoke(null);
         } catch (Throwable ex) { }
	}

	private void executeTestCases(List<TestCase> testCases) {
		for (TestCase testCase : testCases) {
			this.executeTests(testCase.getTests());
		}
		
	}
	
	public void printResults() {
		System.out.printf("Passed: %d, Failed %d%n", numberOfPassedTests, numberOfFailedTests);		
	}
}
