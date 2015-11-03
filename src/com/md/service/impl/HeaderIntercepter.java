package com.md.service.impl;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.helpers.XMLUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.md.common.Constant;

/**
 * 定义cxf Header定义
 * @author wzb
 */
@Service
@Transactional 
public class HeaderIntercepter extends AbstractSoapInterceptor {

	public static final String xml_namespaceUR_att = "http://service.com//authentication";  
	public static final String xml_header_el = "soap:header";  
	public static final String xml_authentication_el = "auth:authentication";  
	public static final String xml_eid_el = "auth:eid";  
	public static final String xml_sk_el = "auth:sk";  
  
    public HeaderIntercepter() {  
        super(Phase.WRITE);  
    }  

    public void handleMessage(SoapMessage message) throws Fault {  
        String eid = Constant.DYNAMIC_COMPANY_ID;  
        String sk = Constant.DYNAMIC_COMPANY_KEY; 
  
        QName qname = new QName("RequestSOAPHeader");
  
        Document doc = (Document) DOMUtils.createDocument();  
        Element root = doc.createElement(xml_header_el);  
        Element eEid = doc.createElement(xml_eid_el);  
        eEid.setTextContent(eid);  
        Element eSk = doc.createElement(xml_sk_el);  
        eSk.setTextContent(sk);  
        Element child = doc.createElementNS(xml_namespaceUR_att,  xml_authentication_el);  
        child.appendChild(eEid);  
        child.appendChild(eSk);  
        root.appendChild(child);  
        XMLUtils.printDOM(root);
        SoapHeader head = new SoapHeader(qname, root);  
        List<Header> headers = message.getHeaders();  
        headers.add(head);  
    }  
}
