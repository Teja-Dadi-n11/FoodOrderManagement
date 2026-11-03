package com.cp.dto;

import java.util.List;

import com.cp.customannotations.NotNull;

public class PartnerOutletRequestDto {
	
	@NotNull
	private String outletName;

	@NotNull
	private String outletCode;
	private String outletDescription;
	
	private String outletOpenTime;
	
	private String outletCloseTime;
	
	@NotNull
	private String branch;
	private String openDays;

	private String status;
	@NotNull
	private PartnerMenuRequestDto partnerMenuRequestDto;
	@NotNull
	private List<PartnerCuisineRequestDto> partnerCuisineRequestDtos;
	public String getOutletName() {
		return outletName;
	}
	public void setOutletName(String outletName) {
		this.outletName = outletName;
	}
	public String getOutletDescription() {
		return outletDescription;
	}
	public void setOutletDescription(String outletDescription) {
		this.outletDescription = outletDescription;
	}
	public String getOutletOpenTime() {
		return outletOpenTime;
	}
	public void setOutletOpenTime(String outletOpenTime) {
		this.outletOpenTime = outletOpenTime;
	}
	public String getOutletCloseTime() {
		return outletCloseTime;
	}
	public void setOutletCloseTime(String outletCloseTime) {
		this.outletCloseTime = outletCloseTime;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getOpenDays() {
		return openDays;
	}
	public void setOpenDays(String openDays) {
		this.openDays = openDays;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public PartnerMenuRequestDto getPartnerMenuRequestDto() {
		return partnerMenuRequestDto;
	}
	public void setPartnerMenuRequestDto(PartnerMenuRequestDto partnerMenuRequestDto) {
		this.partnerMenuRequestDto = partnerMenuRequestDto;
	}
	public List<PartnerCuisineRequestDto> getPartnerCuisineRequestDtos() {
		return partnerCuisineRequestDtos;
	}
	public void setPartnerCuisineRequestDtos(List<PartnerCuisineRequestDto> partnerCuisineRequestDtos) {
		this.partnerCuisineRequestDtos = partnerCuisineRequestDtos;
	}

	public String getOutletCode() {
		return outletCode;
	}

	public void setOutletCode(String outletCode) {
		this.outletCode = outletCode;
	}
}
