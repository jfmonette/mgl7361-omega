package mgl7361.framework;

import java.lang.reflect.Method;

class Test {
	private Method testMethod, setupMethod, tearDownMethod;
	
	protected Test(Method testMethod, Method setupMethod, Method tearDownMethod) {
		this.testMethod = testMethod;
		this.setupMethod = setupMethod;
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
