package com.cp.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cuisineCategory",schema="public")
public class CuisineCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cuisineCategoryKey;
	
	
	private String cuisineCateCode;
	
	private String categoryDescription;

	private Integer isActive;
	
	@OneToMany(mappedBy="cuisineCategory",cascade = CascadeType.ALL)
	private List<CuisineDetails> cuisineDetails;

	public Long getCuisineCategoryKey() {
		return cuisineCategoryKey;
	}

	public void setCuisineCategoryKey(Long cuisineCategoryKey) {
		this.cuisineCategoryKey = cuisineCategoryKey;
	}

	public String getCuisineCateCode() {
		return cuisineCateCode;
	}

	public void setCuisineCateCode(String cuisineCateCode) {
		this.cuisineCateCode = cuisineCateCode;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public List<CuisineDetails> getCuisineDetails() {
		return cuisineDetails;
	}

	public void setCuisineDetails(List<CuisineDetails> cuisineDetails) {
		this.cuisineDetails = cuisineDetails;
	}
	
	
	

}
