package com.cp.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="cuisinecategory",schema="public")
public class CuisineCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cuisineCategoryKey;
	
	//@Column(unique = true)
	private String cuisineCateCode;
	
	private String categoryDescription;

	private Integer isActive;
	
	@OneToMany(mappedBy="cuisineCategory")
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
