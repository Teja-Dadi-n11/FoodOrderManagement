package com.cp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cusinedetails",schema="public")
public class CuisineDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cuisineKey;
	
	private String cuisineName;
	
	private String cusineDescription;

	private String cusineRating;

	private Integer isActive;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="menukey",nullable=false)
	private MenuDetails menuDetails;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cuisineCategoryKey",nullable = false)
	private CuisineCategory cuisineCategory;

	public Long getCuisineKey() {
		return cuisineKey;
	}

	public void setCuisineKey(Long cuisineKey) {
		this.cuisineKey = cuisineKey;
	}

	public String getCuisineName() {
		return cuisineName;
	}

	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}

	public String getCusineDescription() {
		return cusineDescription;
	}

	public void setCusineDescription(String cusineDescription) {
		this.cusineDescription = cusineDescription;
	}

	public String getCusineRating() {
		return cusineRating;
	}

	public void setCusineRating(String cusineRating) {
		this.cusineRating = cusineRating;
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

	public CuisineCategory getCuisineCategory() {
		return cuisineCategory;
	}

	public void setCuisineCategory(CuisineCategory cuisineCategory) {
		this.cuisineCategory = cuisineCategory;
	}
	
	
	

}
