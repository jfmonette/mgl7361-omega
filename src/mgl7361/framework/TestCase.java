package mgl7361.framework;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
	private List<Test> tests = new ArrayList<Test>();
	
	protected TestCase() {
		
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
