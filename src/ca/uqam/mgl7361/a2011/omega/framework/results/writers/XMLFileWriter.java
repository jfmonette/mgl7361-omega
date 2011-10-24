package ca.uqam.mgl7361.a2011.omega.framework.results.writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ca.uqam.mgl7361.a2011.omega.framework.results.Result;

public class XMLFileWriter implements Writer{
	@Override
	public void write(Result result) {
		try {
		FileWriter fileStream = new FileWriter(result.getName() + ".xml");
		BufferedWriter out = new BufferedWriter(fileStream);
		out.write(this.getXMLContent(result));
		out.close();
		}
		catch (IOException ex) {
			
		}
		
	}

	private char[] getXMLContent(Result result) {
		// TODO Auto-generated method stub
		return null;
	}
}
