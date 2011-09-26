package mgl7361.framework;


public class Assertion {
	public static void AssertExpectedEqualsResult(Object expected, Object result) {
		if (!expected.equals(result)) {
			throw new AssertionError();
		}
	}

}
