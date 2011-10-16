package mgl7361.framework;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mgl7361.framework.annotation.*;

public class TestCaseFactory {
	private TestCaseFactory() { };
	
	private static class SingletonHolder { 
        public static final TestCaseFactory instance = new TestCaseFactory();
	}
	
	public static TestCaseFactory getInstance() {
        return SingletonHolder.instance;
	}
	
	public TestCase makeTestCase(String className) throws ClassNotFoundException {
		Class<?> klass = this.parseClass(className);
		List<Method> methods = this.extractMethods(klass);
		return this.buildTestCase(className, methods);
	}

	private Class<?> parseClass(String className) throws ClassNotFoundException {
		return Class.forName(className);
	}
	
	private List<Method> extractMethods(Class<?> klass) {
		return Arrays.asList(klass.getMethods());
	}
	
	private TestCase buildTestCase(String testCaseName, List<Method> methods) {
		Method setupMethod = this.getSetupMethod(methods);
		List<Method> testMethods = this.getTestMethods(methods);
		Method teardownMethod = this.getTearDownMethod(methods);
		TestCase testCase = new TestCase(testCaseName);
		testCase.addAll(this.buildTests(setupMethod, testMethods, teardownMethod));
		return testCase;
	}

	private Method getSetupMethod(List<Method> methods) {
		Method setupMethod = null;
		for (Method method : methods) {
			if (method.isAnnotationPresent(Setup.class)){
				setupMethod = method;
			}
		}
		return setupMethod;
	}
	
	private Method getTearDownMethod(List<Method> methods) {
		Method teardownMethod = null;
		for (Method method : methods) {
			if (method.isAnnotationPresent(Teardown.class)){
				teardownMethod = method;
			}
		}
		return teardownMethod;
	}
	
	private List<Method> getTestMethods(List<Method> methods) {
		List<Method> testAnnontatedMethods = new ArrayList<Method>();
		for (Method method : methods) {
			if (method.isAnnotationPresent(mgl7361.framework.annotation.Test.class)){
				testAnnontatedMethods.add(method);
			}
		}
		return testAnnontatedMethods;
	}
	
	private List<Test> buildTests(Method setupMethod, List<Method> testMethods,
			Method teardownMethod) {
		List<Test> tests = new ArrayList<Test>();
		for (Method testMethod : testMethods) {
			tests.add(new Test(setupMethod, testMethod, teardownMethod));
		}
		return tests;	
	}
}
