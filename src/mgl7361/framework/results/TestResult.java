package mgl7361.framework.results;

public class TestResult {
	private String TestName;
	private boolean isPassed;
	
	public TestResult(String testName, boolean isPassed) {
		super();
		this.TestName = testName;
		this.isPassed = isPassed;
	}

	public String getTestName() {
		return TestName;
	}

	public boolean isPassed() {
		return isPassed;
	}
}
