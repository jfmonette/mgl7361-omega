package ca.uqam.mgl7361.a2011.omega.framework.results;

import java.util.ArrayList;
import java.util.List;

public class Result {
	private String name;
	private ResultType resultType;
	private int numberOfSuccessfullTests = 0;
	private int numberOfFailedTests = 0;
	private List<Result> subResults = new ArrayList<Result>();
	
	
	public Result(String name, ResultType resultType,
			int numberOfSuccessfullTests, int numberOfFailedTests) {
		super();
		this.name = name;
		this.resultType = resultType;
		this.numberOfSuccessfullTests = numberOfSuccessfullTests;
		this.numberOfFailedTests = numberOfFailedTests;
	}
	public String getName() {
		return name;
	}
	public ResultType getResultType() {
		return resultType;
	}
	public void add(Result subResult) {
		this.subResults.add(subResult);
	}

	public int getNumberOfSuccessfullTests() {
		return numberOfSuccessfullTests + this.getNumberOfSuccessfullTests(subResults);
	}
	public int getNumberOfFailedTests() {
		return numberOfFailedTests + this.getNumberOfFailedTests(subResults); 
	}
	public List<Result> getSubResults() {
		return subResults;
	}	
	private int getNumberOfSuccessfullTests(List<Result> subResults) {
		int numberOfSuccessfulTests = 0;
		for(Result result : subResults) {
			numberOfSuccessfulTests =+ result.getNumberOfSuccessfullTests();
		}
		return numberOfSuccessfulTests;
	}
	private int getNumberOfFailedTests(List<Result> subResults) {
		int numberOfFailedTests = 0;
		for(Result result : subResults) {
			numberOfFailedTests =+ result.getNumberOfFailedTests();
		}
		return numberOfFailedTests;
	}
}
