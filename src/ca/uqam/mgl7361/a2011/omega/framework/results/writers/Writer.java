package ca.uqam.mgl7361.a2011.omega.framework.results.writers;

import ca.uqam.mgl7361.a2011.omega.framework.results.Result;
import ca.uqam.mgl7361.a2011.omega.framework.results.formats.Format;

public interface Writer {
	void write(Result result, Format format);
}
