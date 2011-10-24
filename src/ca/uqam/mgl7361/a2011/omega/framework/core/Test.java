package ca.uqam.mgl7361.a2011.omega.framework.core;

import java.lang.reflect.Method;

class Test {
	private Method testMethod, setupMethod, tearDownMethod;
	
	protected Test(Method setupMethod, Method testMethod, Method tearDownMethod) {
		this.setupMethod = setupMethod;
		this.testMethod = testMethod;
		this.tearDownMethod = tearDownMethod;		
	}
	
	protected Method getTestMethod() {
		return this.testMethod;
	}
	
	protected Method getSetupMethod() {
		return this.setupMethod;
	}
	
	protected Method getTearDownMethod() {
		return this.tearDownMethod;
	}
}
