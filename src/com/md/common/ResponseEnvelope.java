package com.md.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 针对普通的异步调用返回jso处理
 * @author wzb
 */

@Scope("prototype")
@Component
public class ResponseEnvelope<T> {
	private boolean success = true;
	private String message = "ok";
	private String data;
	private long totalSize;
	private boolean state = true;
	private List<T> list;
	private Object obj;
	private String url;
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public ResponseEnvelope(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public ResponseEnvelope() {
		this.totalSize = 0;
		this.list = new ArrayList<T>();
	}

	public ResponseEnvelope(Object obj) {
		this.obj = obj;
	}
	
	public ResponseEnvelope(Object obj,String data) {
		this.obj = obj;
		this.data = data;
	}

	public ResponseEnvelope(long totalSize, List list) {
		this.totalSize = totalSize;
		this.list = list;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
