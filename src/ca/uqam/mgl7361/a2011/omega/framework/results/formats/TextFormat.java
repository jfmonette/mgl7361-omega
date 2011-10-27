package ca.uqam.mgl7361.a2011.omega.framework.results.formats;

import ca.uqam.mgl7361.a2011.omega.framework.results.Result;

public class TextFormat implements Format {

	@Override
	public String getFormattedResult(Result result) {
		return getIndentedFormattedResult(result, "");
	}

	private String getIndentedFormattedResult(Result result, String identation) {
		StringBuilder textFormattedResult = new StringBuilder();
		textFormattedResult.append(identation + "Result\n");
		textFormattedResult.append(identation + "======\n");
		textFormattedResult.append(identation + "Type : " + result.getResultType().getName() + "\n");
		textFormattedResult.append(identation + "Name : " + result.getName() + "\n");
		textFormattedResult.append(identation + "Successful tests : " + result.getNumberOfSuccessfullTests() + "\n");
		textFormattedResult.append(identation + "Failed tests : " + result.getNumberOfFailedTests() + "\n");
		textFormattedResult.append("\n");
		for(Result subResult : result.getSubResults()) {
			textFormattedResult.append(this.getIndentedFormattedResult(subResult, identation + "    " ));
		}
		return textFormattedResult.toString();	
	}

	@Override
	public String getFormatExtension() {
		return "txt";
	}
}
