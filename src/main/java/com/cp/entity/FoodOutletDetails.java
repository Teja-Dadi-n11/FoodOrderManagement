package com.cp.entity;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.*;


@Entity
@Table(
        name = "outletdetails",
        schema = "public",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"outlet_name", "outlet_code"}
                )
        }
)
public class FoodOutletDetails {
	private String outletName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long outletKey;

	private String outletCode;
	private String outletDescription;
	
	
	private LocalTime openTime;
	
	private LocalTime closeTime;
	
	private String outletRating;
	
	private String branchName;

	private String outletLocation;

	private Integer isActive;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "menuKey") // Foreign key column in the FoodOutletDetails table
	private MenuDetails menuDetails;

	public String getOutletName() {
		return outletName;
	}

	public void setOutletName(String outletName) {
		this.outletName = outletName;
	}

	public Long getOutletKey() {
		return outletKey;
	}

	public void setOutletKey(Long outletKey) {
		this.outletKey = outletKey;
	}

	public String getOutletDescription() {
		return outletDescription;
	}

	public void setOutletDescription(String outletDescription) {
		this.outletDescription = outletDescription;
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

	public String getOutletLocation() {
		return outletLocation;
	}

	public void setOutletLocation(String outletLocation) {
		this.outletLocation = outletLocation;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	public MenuDetails getMenuDetails() {
		return menuDetails;
	}

	public void setMenuDetails(MenuDetails menuDetails) {
		this.menuDetails = menuDetails;
	}


	public String getOutletCode() {
		return outletCode;
	}

	public void setOutletCode(String outletCode) {
		this.outletCode = outletCode;
	}

	public Map<String,Object> toMap(){
		Map<String,Object>document=new HashMap<String, Object>();
		document.put("restaurantid", outletKey);
		document.put("outletname", outletName);
		document.put("location", outletLocation);
		document.put("cuisine", menuDetails.getCuisineDetails());
		document.put("rating",outletRating);
		
		return document;
	}
	
	
	
	
	

}
