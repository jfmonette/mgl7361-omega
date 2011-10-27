package ca.uqam.mgl7361.a2011.omega.framework.results.formats;

import ca.uqam.mgl7361.a2011.omega.framework.results.Result;

public interface Format {
	String getFormattedResult(Result result);
	String getFormatExtension();
}
