package ca.uqam.mgl7361.a2011.omega.framework.core;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
	private List<Test> tests = new ArrayList<Test>();
	private String name;
	
	protected TestCase() {
		name = "Unnamed test case";
	}
	
	protected TestCase(String testClassName) {
		this.name = testClassName;
	}
	
	protected String getName() {
		return name;
	}
	
	protected void add(Test test) {
		this.tests.add(test);
	}
	
	protected void addAll(List<Test> tests) {
		this.tests.addAll(tests);
	}
	
	protected List<Test> getTests() {
		return this.tests;
	}
}
