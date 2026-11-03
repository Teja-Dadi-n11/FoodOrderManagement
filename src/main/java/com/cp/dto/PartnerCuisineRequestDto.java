package com.cp.dto;

public class PartnerCuisineRequestDto {

	private String cuisineName;

	private String cuisineDescription;

	private String cuisineCode;
	
	private String cuisineCategoryCode;
	
	private String cuisineCatDescription;

	private String status;

	public String getCuisineName() {
		return cuisineName;
	}

	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}

	public String getCuisineDescription() {
		return cuisineDescription;
	}

	public void setCuisineDescription(String cuisineDescription) {
		this.cuisineDescription = cuisineDescription;
	}

	public String getCuisineCode() {
		return cuisineCode;
	}

	public void setCuisineCode(String cuisineCode) {
		this.cuisineCode = cuisineCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCuisineCategoryCode() {
		return cuisineCategoryCode;
	}

	public void setCusineCategoryCode(String cuisineCategoryCode) {
		this.cuisineCategoryCode = cuisineCategoryCode;
	}

	public String getCuisineCatDescription() {
		return cuisineCatDescription;
	}

	public void setCuisineCatDescription(String cuisineCatDescription) {
		this.cuisineCatDescription = cuisineCatDescription;
	}
	
	

}
