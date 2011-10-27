package ca.uqam.mgl7361.a2011.omega.framework.results.formats;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import ca.uqam.mgl7361.a2011.omega.framework.results.Result;

public class XMLFormat implements Format {
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	private Transformer transformer;
	
	public XMLFormat() {
		factory = DocumentBuilderFactory.newInstance();
		try {
			builder = factory.newDocumentBuilder();
			document = builder.newDocument();
			transformer = TransformerFactory.newInstance().newTransformer();
			setUpTransformer();
		} catch (Exception e) {
			System.out.print("Unable to configure XMLFormat object. Call Batman.");
		}
	}
	
	private void setUpTransformer() {
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(2));	
	}

	@Override
	public String getFormattedResult(Result result) {
		return getXMLFormattedResult(result);
	}

	private String getXMLFormattedResult(Result result)  {
		document.appendChild(getResultElement(result));
		String resultString = toString(document);
		return resultString;
	}
	
	private String toString(Document resultDocument) {
		String xmlString = "";
		try {
			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(resultDocument.getDocumentElement());
			transformer.transform(source, result);
			xmlString = sw.toString();
		} catch (Exception e) {
			System.out.print("Unable to transform XML Document to string. Call Ironman.");
		}
		
		return xmlString;
	}
	
	private Element getResultElement(Result result) {
		Element resultElement = document.createElement(result.getName().toString());
		resultElement.setAttribute("Type", result.getResultType().getName());
		resultElement.appendChild(getSuccessfullTestNode(result));
		resultElement.appendChild(getFailedTestNode(result));
		for (Result subResultresult : result.getSubResults()) {
			resultElement.appendChild(getResultElement(subResultresult));
		}
		return resultElement;
	}

	private Node getSuccessfullTestNode(Result result) {
		Element successfullTestsElement = document.createElement("SuccessfullTests");
		successfullTestsElement.setTextContent(Integer.toString(result.getNumberOfSuccessfullTests()));
		return successfullTestsElement;
	}
	
	private Node getFailedTestNode(Result result) {
		Element failedTestsElement = document.createElement("FailedTests");
		failedTestsElement.setTextContent(Integer.toString(result.getNumberOfFailedTests()));
		return failedTestsElement;
	}

	@Override
	public String getFormatExtension() {
		return "xml";
	}
}
