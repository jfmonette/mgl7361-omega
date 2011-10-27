package ca.uqam.mgl7361.a2011.omega.framework.results.writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ca.uqam.mgl7361.a2011.omega.framework.results.Result;
import ca.uqam.mgl7361.a2011.omega.framework.results.formats.Format;

public class TextFileWriter implements Writer{

	@Override
	public void write(Result result, Format format) {
		String formattedResult = format.getFormattedResult(result);
		try {
		FileWriter fileStream = new FileWriter(result.getName() + "." + format.getFormatExtension());
		BufferedWriter out = new BufferedWriter(fileStream);
		out.write(formattedResult);
		out.close();
		}
		catch (IOException ex) {
			System.out.print("Unable to write to file. Call Superman.");
		}	
	}
}
