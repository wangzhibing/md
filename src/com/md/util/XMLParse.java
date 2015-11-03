package com.md.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParse {
	Document document = null;

	NodeList allNode = null;

	/**
	 * 解析动态xml，转货result结果
	 * @param responseXml
	 * @return
	 */
	public static String getResponseResult(String responseXml) {

		String val = "";
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			// 建立DocumentBuilder对象
			builder = builderFactory.newDocumentBuilder();
			// 用DocumentBuilder对象的parse方法引入文件建立Document对象
			InputStream is = new ByteArrayInputStream(responseXml.getBytes());
			Document document = builder.parse(is);

			NodeList responseNode = document.getElementsByTagName("response");

			// 按条件输出peron标签中的属性和值
			val = XMLParse.getNodeText(responseNode);
			System.out.println(val);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("找不到你指定的文件！");
			e.printStackTrace();
		}

		return val;
	}

	// 按条件输出
	public static String getNodeText(NodeList allNode) {
		String nodeText = "";
		Element element;
		// 对符合条件的所有节点进行遍历
		for (int i = 0; i < allNode.getLength(); i++) {
			// 获得一个元素
			element = (Element) allNode.item(i);
			NodeList personList = element.getChildNodes();
			// 遍历所有子节点
			for (int j = 0; j < personList.getLength(); j++) {
				if ("result".equals(personList.item(j).getNodeName())) {
					nodeText = personList.item(j).getTextContent();
					break;
				}
			}
		}
		return nodeText;
	}
}