package org.utility;

public class FrameWorkException extends Exception {
	private static final long serialVersionUID = 1L;
	public String exceptionMessage;
	public FrameWorkException(String mssg) {
		exceptionMessage =mssg;
		
		// TODO Auto-generated constructor stub
	}
	public String getExceptionMessage() {
		return this.exceptionMessage;
	}
	

	
	
}
