package mgl7361.framework.results;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ResultsFileWriter {
	private FileWriter fileStream;
	
	public void write(TestSuiteResult testSuiteResult) throws IOException {
		this.fileStream = new FileWriter("TestSuiteResult_" + testSuiteResult.getTestSuiteName() + ".txt");
		BufferedWriter out = new BufferedWriter(this.fileStream);
		out.write(testSuiteResult.toString());
		out.close();
	}

	public void write(TestCaseResult testCaseResult) throws IOException {
		this.fileStream = new FileWriter("TestSuiteResult_" + testCaseResult.getTestCaseName() + ".txt");
		BufferedWriter out = new BufferedWriter(this.fileStream);
		out.write(testCaseResult.toString());
		out.close();		
	}
	
	public void write(TestResult testResult) throws IOException {
		this.fileStream = new FileWriter("TestSuiteResult_" + testResult.getTestName() + ".txt");
		BufferedWriter out = new BufferedWriter(this.fileStream);
		out.write(testResult.toString());
		out.close();		
	}
}
