package mgl7361.framework;

import mgl7361.framework.results.TestCaseResult;
import mgl7361.framework.results.TestResult;
import mgl7361.framework.results.TestSuiteResult;

class TestRunner {
	private TestRunner() { }
	
	private static class SingletonHolder { 
        public static final TestRunner instance = new TestRunner();
	}
	
	public static TestRunner getInstance() {
        return SingletonHolder.instance;
	}
	
	public TestSuiteResult execute(TestSuite testSuite){
		TestSuiteResult testSuiteResult = new TestSuiteResult(testSuite.getName());
		for(TestCase testCase : testSuite.getTestCases()) {
			testSuiteResult.add(this.execute(testCase));
		}
		for (TestSuite innerTestSuite : testSuite.getTestSuites()) {
			testSuiteResult.add(this.execute(innerTestSuite));
		}
		return testSuiteResult;
	}

	public TestCaseResult execute(TestCase testCase) {
		TestCaseResult testCaseResult = new TestCaseResult(testCase.getName());
		for (Test test : testCase.getTests()) {
			testCaseResult.addTestResult(this.execute(test));			
		}
		return testCaseResult;
	}
	
	public TestResult execute(Test test) {
		TestResult testResult;
		try {
			this.executeSetup(test);
			test.getTestMethod().invoke(null);
			this.executeTearDown(test);
			testResult = new TestResult(test.getTestMethod().getName(), true);
         } catch (Throwable ex) {
        	 testResult = new TestResult(test.getTestMethod().getName(), false);
         }
         return testResult;
	}
	
	private void executeSetup(Test test) {
		try {
			test.getSetupMethod().invoke(null);
		} catch (Throwable ex) {
            // TODO: throw something
        }
	}

	private void executeTearDown(Test test) {
		try {
			test.getTearDownMethod().invoke(null);
		} catch (Throwable ex) {
            // TODO: throw something
        }
	}		
}
