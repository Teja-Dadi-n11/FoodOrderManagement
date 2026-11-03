package com.cp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cp.customannotations.NotNull;
import com.cp.customexceptions.FoodOrderManagementServiceException;
import com.cp.dto.ErrorBean;
import com.cp.dto.PartnerOutletRequestDto;
import com.cp.dto.ResponseBean;
import com.cp.service.OutletManagementService;

@RestController
public class PartnerOutletController {
	
	 @Autowired
     OutletManagementService outletManagementService;
	 
	 @CrossOrigin
	 @PostMapping("v1/food/register/outlet")
	 public ResponseEntity<?> registerEntity(@RequestBody PartnerOutletRequestDto partnerOutletRequestDto){
		 ResponseBean responseBean = new ResponseBean();
		 try {
			 responseBean = outletManagementService.registerOutlet(partnerOutletRequestDto);
		 }
		 catch(FoodOrderManagementServiceException e) {
			 ErrorBean errorBean=new ErrorBean();
			 errorBean.setErrorcode(e.getErrorCode());
			 errorBean.setErrorMessage(e.getMessage());
			 responseBean.setErrorBean(errorBean);
			 return new ResponseEntity<ResponseBean>(responseBean,HttpStatusCode.valueOf(Integer.valueOf(e.getErrorCode())));
		 }
		 return new ResponseEntity<>(responseBean,HttpStatus.OK);
	 }
	 
	 @CrossOrigin
	 @PutMapping("v1/food/update/outlet")
	 public ResponseEntity<?> updateOutlet(@RequestBody @NotNull PartnerOutletRequestDto partnerOutletRequestDto){
		 ResponseBean responseBean = new ResponseBean();
		 try {
			 responseBean = outletManagementService.updateOutlet(partnerOutletRequestDto);
		 }
		 catch(FoodOrderManagementServiceException e) {
			 ErrorBean errorBean=new ErrorBean();
			 errorBean.setErrorcode(e.getErrorCode());
			 errorBean.setErrorMessage(e.getMessage());
			 responseBean.setErrorBean(errorBean);
			 return new ResponseEntity<ResponseBean>(responseBean,HttpStatusCode.valueOf(Integer.valueOf(e.getErrorCode())));
		 }
		 return new ResponseEntity<>(responseBean,HttpStatus.OK);
	 }
	 
	 
     
}
