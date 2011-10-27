package ca.uqam.mgl7361.a2011.omega.framework.results.writers;

import ca.uqam.mgl7361.a2011.omega.framework.results.Result;
import ca.uqam.mgl7361.a2011.omega.framework.results.formats.Format;

public class ConsoleWriter implements Writer{

	@Override
	public void write(Result result, Format format) {
		String formattedResult = format.getFormattedResult(result);
		System.out.print(formattedResult);
	}
}
