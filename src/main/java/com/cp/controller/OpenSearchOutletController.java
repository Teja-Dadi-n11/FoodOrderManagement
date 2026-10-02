package com.cp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cp.dto.OutletMappingRequestDto;
import com.cp.dto.OutletMappingResponseDto;
import com.cp.service.OpenSearchOutletService;

@RestController
public class OpenSearchOutletController {
	
	@Autowired
	private OpenSearchOutletService openSearchOutletService;
	
	@PostMapping("/index/outlet")
	public ResponseEntity<?> indexOutlet(@RequestBody OutletMappingRequestDto outletMappingRequestDto ){
		String response = openSearchOutletService.indexOutlet(outletMappingRequestDto);
		OutletMappingResponseDto reOutletMappingResponseDto=new OutletMappingResponseDto();
		
		reOutletMappingResponseDto.setPayload(response);
		reOutletMappingResponseDto.setStatus("Success");
		
		return new ResponseEntity(reOutletMappingResponseDto,HttpStatus.OK);
		
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> searchByOutletName(@RequestParam String outletName){
		String searchResult = openSearchOutletService.getOutletByName(outletName);
        OutletMappingResponseDto reOutletMappingResponseDto=new OutletMappingResponseDto();
		
		reOutletMappingResponseDto.setPayload(searchResult);
		reOutletMappingResponseDto.setStatus("Success");
		
		return new ResponseEntity(reOutletMappingResponseDto,HttpStatus.OK);
	}
	
	@GetMapping("/search/FullText")
	public ResponseEntity<?> searchOutletByFullText(@RequestParam String searchText,@RequestParam Double userLatitude,@RequestParam Double userLongitude){
		String searchResult = openSearchOutletService.searchByFullText(searchText, userLatitude, userLongitude);
        OutletMappingResponseDto reOutletMappingResponseDto=new OutletMappingResponseDto();
		
		reOutletMappingResponseDto.setPayload(searchResult);
		reOutletMappingResponseDto.setStatus("Success");
		
		return new ResponseEntity(reOutletMappingResponseDto,HttpStatus.OK);
	}

}
