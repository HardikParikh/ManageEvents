package com.tm.fan.event.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EventException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorMsg;
	private String errorCode;
	private String errorType;
	
	public EventException(){
		
	}
	
	public EventException(String eMsg, String eCode, String eType){
		this.errorMsg = eMsg;
		this.errorCode = eCode;
		this.errorType = eType;
	}

	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
}
