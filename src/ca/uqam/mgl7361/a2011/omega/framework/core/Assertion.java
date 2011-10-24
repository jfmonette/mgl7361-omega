package ca.uqam.mgl7361.a2011.omega.framework.core;

public class Assertion {
	public static void AssertExpectedEqualsResult(Object expected, Object result) {
		if (!expected.equals(result)) {
			throw new AssertionError();
		}
	}

}
