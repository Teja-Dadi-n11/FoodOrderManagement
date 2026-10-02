package com.cp.dto;

import java.time.LocalTime;

import org.opensearch.common.geo.GeoPoint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OutletMappingRequestDto {
	
	@JsonProperty("outletid")
	private String outletId;	
	
	@JsonProperty("outletname")
	private String outletName;
	
	@JsonProperty("opentime")
	@JsonFormat(pattern="HH:mm")
	private LocalTime openTime;
	
	@JsonProperty("closetime")
	@JsonFormat(pattern="HH:mm")
	private LocalTime closeTime;
	
	@JsonProperty("rating")
	private String outletRating;
	
	private String branchName;
    
	@JsonProperty("isactive")
	private Integer isActive;
	
	@JsonProperty("outletlocation")
	private GeoPoint outletLocation;

	public String getOutletId() {
		return outletId;
	}

	public void setOutletId(String outletId) {
		this.outletId = outletId;
	}

	public String getOutletName() {
		return outletName;
	}

	public void setOutletName(String outletName) {
		this.outletName = outletName;
	}

	public LocalTime getOpenTime() {
		return openTime;
	}

	public void setOpenTime(LocalTime openTime) {
		this.openTime = openTime;
	}

	public LocalTime getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(LocalTime closeTime) {
		this.closeTime = closeTime;
	}

	public String getOutletRating() {
		return outletRating;
	}

	public void setOutletRating(String outletRating) {
		this.outletRating = outletRating;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public GeoPoint getOutletLocation() {
		return outletLocation;
	}

	public void setOutletLocation(GeoPoint outletLocation) {
		this.outletLocation = outletLocation;
	}
	
	

}
