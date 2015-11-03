package com.md.service.impl;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.cxf.helpers.DOMUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Mds {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String repsonse = "<response>" +
							"<result>2</result>" +
							"<desc>FAILED</desc>" +
						  "</response>";
		StringReader sr = new StringReader(repsonse);
		Document doc = null;
	    try {
		    doc = DOMUtils.readXml(sr);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    NodeList li = doc.getChildNodes();
	    System.out.println("xxxxxxxx");
	}

}
