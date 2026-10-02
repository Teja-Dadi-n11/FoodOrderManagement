package com.cp.service;

import com.cp.dto.OutletMappingRequestDto;

public interface OpenSearchOutletService {
	
	public String indexOutlet(OutletMappingRequestDto outletMappingRequestDto);
	
	public String getOutletByName(String outletName);
	
	public String searchByFullText(String searchText,Double userLatitude,Double userLongitude);
}
