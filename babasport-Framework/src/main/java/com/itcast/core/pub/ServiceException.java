package com.itcast.core.pub;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;

public class ServiceException extends Exception{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 5713814013800006249L;

	private int code=1;
	
	private String content;
	
	private Map<String,Object> maps;
	
	public ServiceException(){
		this.code=1;
		this.content="error";
	}
	public ServiceException(Exception e){
		super(e);
	}

	public ServiceException(int code){
		this.code=code;
		this.content="";
	}
	
	public ServiceException(int code, String message){
		this.code=code;
		this.content=message;
	}
	
	public ServiceException(int code, Map<String,Object> maps){
		this.code=code;
		this.maps=maps;
	}
	
	@Override
    public synchronized Throwable getCause() {
	    return super.getCause();
    }

	@Override
    public synchronized Throwable initCause(Throwable cause) {
	    return super.initCause(cause);
    }

	@Override
    public void printStackTrace() {
	    super.printStackTrace();
    }

	@Override
    public void printStackTrace(PrintStream s) {
	    super.printStackTrace(s);
    }

	@Override
    public void printStackTrace(PrintWriter s) {
	    super.printStackTrace(s);
    }

	@Override
    public synchronized Throwable fillInStackTrace() {
	    return super.fillInStackTrace();
    }

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	@Override
	public String getLocalizedMessage() {
		return super.getLocalizedMessage();
	}

	@Override
	public String toString() {

		return  Message.error(getCode()).toString();
		//return super.toString();
	}
	
	public int getCode() {
		return code;
	}

	public String getContent() {
		return content;
	}

	public Map<String, Object> getMaps() {
		return maps;
	}

}
