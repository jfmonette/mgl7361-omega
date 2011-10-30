package ca.uqam.mgl7361.a2011.omega.framework.core;

public class Assertion {
	public static void AssertExpectedEqualsActual(Object expected, Object actual) {
		if (expected == null && actual == null)
			return;
		if (expected != null && expected.equals(actual))
			return;
		throw new AssertionError();
	}

}
