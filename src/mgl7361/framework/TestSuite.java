package mgl7361.framework;

import mgl7361.framework.TestCase;

import java.util.Collection;
import java.util.LinkedList;

public class TestSuite {
	private String name = "";
	private Collection<TestCase> testCases = new LinkedList<TestCase>();
	
	public TestSuite(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void  AddTestCase(TestCase testCase) {
		this.testCases.add(testCase);
	}
	
	public Collection<TestCase> GetTestCases() {
		return this.testCases;
	}
}