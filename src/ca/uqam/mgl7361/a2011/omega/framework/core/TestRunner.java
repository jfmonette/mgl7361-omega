package ca.uqam.mgl7361.a2011.omega.framework.core;

import ca.uqam.mgl7361.a2011.omega.framework.results.*;

public class TestRunner {
	private TestRunner() { }
	
	private static class SingletonHolder { 
        public static final TestRunner instance = new TestRunner();
	}
	
	public static TestRunner getInstance() {
        return SingletonHolder.instance;
	}
	
	public Result execute(TestSuite testSuite){
		Result testSuiteResult = new Result(testSuite.getName(), new ResultType("Test Suite"), 0, 0);
		for(TestCase testCase : testSuite.getTestCases()) {
			testSuiteResult.add(this.execute(testCase));
		}
		for (TestSuite innerTestSuite : testSuite.getTestSuites()) {
			testSuiteResult.add(this.execute(innerTestSuite));
		}
		return testSuiteResult;
	}

	public Result execute(TestCase testCase) {
		Result testCaseResult = new Result(testCase.getName(), new ResultType("Test Case"), 0, 0);
		for (Test test : testCase.getTests()) {
			testCaseResult.add(this.execute(test));			
		}
		return testCaseResult;
	}
	
	public Result execute(Test test) {
		Result testResult;
		try {
			this.executeSetup(test);
			test.getTestMethod().invoke(null);
			this.executeTearDown(test);
			testResult = new Result(test.getTestMethod().getName(), new ResultType("Test"), 1, 0);
         } catch (Throwable ex) {
        	 testResult = new Result(test.getTestMethod().getName(), new ResultType("Test"), 0, 1);
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
