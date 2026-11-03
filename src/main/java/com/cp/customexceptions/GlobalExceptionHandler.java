package com.cp.customexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cp.dto.ErrorBean;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(FoodOrderManagementServiceException.class)
	public ResponseEntity<ErrorBean> handleFoodOrderManagementException(FoodOrderManagementServiceException exception){
		ErrorBean errorBean=new ErrorBean();
		errorBean.setErrorcode(exception.getErrorCode());
		errorBean.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(errorBean,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
