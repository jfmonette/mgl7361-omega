package ca.uqam.mgl7361.a2011.omega.framework.results.writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ca.uqam.mgl7361.a2011.omega.framework.results.Result;

public class TextFileWriter implements Writer{

	@Override
	public void write(Result result) {
		try {
		FileWriter fileStream = new FileWriter(result.getName() + ".txt");
		BufferedWriter out = new BufferedWriter(fileStream);
		this.writeResultToFile(result, out);
		out.close();
		}
		catch (IOException ex) {
			
		}
		
	}

	private void writeResultToFile(Result result, BufferedWriter out) throws IOException {
		out.write("Result\n");
		out.write("======\n");
		out.write("Type : " + result.getResultType().getName() + "\n");
		out.write("Name : " + result.getName() + "\n");
		out.write("Successful tests : " + result.getNumberOfSuccessfullTests() + "\n");
		out.write("Failed tests : " + result.getNumberOfFailedTests() + "\n");
		out.newLine();
		for(Result subResult : result.getSubResults()) {
			this.writeResultToFile(subResult, out);
		}
	}

	

}
