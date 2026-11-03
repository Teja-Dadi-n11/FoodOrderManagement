package com.cp.customexceptions;

public class FoodOrderManagementServiceException extends RuntimeException{
	private static final long serialVersionUID = 1L;
    private String errorCode;
    
    public FoodOrderManagementServiceException() {
    	super();
    }
    public FoodOrderManagementServiceException(String errorcode,String message) {
    	super(message);
    	this.errorCode=errorcode;
    }
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
