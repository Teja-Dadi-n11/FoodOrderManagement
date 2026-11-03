package com.cp.service;


import com.cp.dto.PartnerOutletRequestDto;
import com.cp.dto.ResponseBean;

public interface OutletManagementService {
	
	public ResponseBean registerOutlet(PartnerOutletRequestDto partnerOutletRequestDto);
	
	public ResponseBean updateOutlet(PartnerOutletRequestDto partnerOutletRequestDto);

}
