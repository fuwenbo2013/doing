package com.tarena.vo;

import java.io.Serializable;

public class Result implements Serializable {
	//状态 : 1 成功  0 失败
	private int status;
	//登录信息
	private String message;
	//
	private Object data;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Result [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	
	
}
