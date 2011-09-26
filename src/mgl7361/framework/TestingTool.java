package mgl7361.framework;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import mgl7361.framework.annotation.*;


public class TestingTool {
	private static int numberOfPassedTests = 0, numberOfFailedTests = 0;
	private static Collection<Class<?>> classesToTest = new LinkedList<Class<?>>();
	private static Collection<Method> methodsToTest = new LinkedList<Method>();
	
	public static void main(String[] args) throws Exception {
		ExtractClassesToTestFromArguments(args);
		ExtractMethodsToTestFromClasses();
		RunMethodsToTest();
	
		System.out.printf("Passed: %d, Failed %d%n", numberOfPassedTests, numberOfFailedTests);
	}
	
	private static void ExtractClassesToTestFromArguments(String[] args) throws ClassNotFoundException {
		for (String className : args) {
			classesToTest.add(Class.forName(className));
		}
	}
	
	private static void ExtractMethodsToTestFromClasses() {
		for (Class<?> classToTest : classesToTest) {
			methodsToTest.addAll(Arrays.asList(classToTest.getMethods()));
		}
		RemoveNonTestAnnotatedMethods();
	}
	
	private static void RemoveNonTestAnnotatedMethods() {
		Collection<Method> methodsToRemove = new LinkedList<Method>();
		for (Method method : methodsToTest) {
			if (!method.isAnnotationPresent(Test.class)){
				methodsToRemove.add(method);
			}
		}
		methodsToTest.removeAll(methodsToRemove);	
	}
	
	private static void RunMethodsToTest() {
		for (Method method : methodsToTest) {
			try {
				method.invoke(null);
	            numberOfPassedTests++;
	         } catch (Throwable ex) {
	            numberOfFailedTests++;
	         }
		}
	}
}
