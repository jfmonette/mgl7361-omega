package mgl7361.framework;

import java.util.ArrayList;
import java.util.List;

import mgl7361.framework.results.TestCaseResult;
import mgl7361.framework.results.TestResult;

class TestRunner {
	private TestRunner() { }
	
	private static class SingletonHolder { 
        public static final TestRunner instance = new TestRunner();
	}
	
	public static TestRunner getInstance() {
        return SingletonHolder.instance;
	}
	
	public List<TestCaseResult> execute(TestSuite testSuite){
		List<TestCaseResult> testCaseResults = new ArrayList<TestCaseResult>();
		for (TestCase testCase : testSuite.getTestCases()) {
			testCaseResults.add(this.executeTestCase(testCase));
		}
		return testCaseResults;
	}

	private TestCaseResult executeTestCase(TestCase testCase) {
		TestCaseResult testCaseResult = new TestCaseResult(testCase.getName());
		for (Test test : testCase.getTests()) {
			this.executeSetup(test);
			testCaseResult.addTestResult(this.executeTest(test));
			this.executeTearDown(test);
		}
		return testCaseResult;
	}
	
	private void executeSetup(Test test) {
		try {
			test.getSetupMethod().invoke(null);
		} catch (Throwable ex) {
            // TODO: throw something
        }
	}

	private TestResult executeTest(Test test) {
		TestResult testResult;
		try {
			test.getTestMethod().invoke(null);
			testResult = new TestResult(test.getTestMethod().getName(), true);
         } catch (Throwable ex) {
        	 testResult = new TestResult(test.getTestMethod().getName(), false);
         }
         return testResult;
	}
	
	private void executeTearDown(Test test) {
		try {
			test.getTearDownMethod().invoke(null);
		} catch (Throwable ex) {
            // TODO: throw something
        }
	}		
}
