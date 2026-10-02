package com.cp.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="menudetails",schema="public")
public class MenuDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType. IDENTITY)
	private Long menuKey;
	
	private String menuName;
	
	private String menuDescription;
	
	@OneToOne(mappedBy = "menuDetails",cascade = CascadeType.ALL)
	private FoodOutletDetails foodOutletDetails;
	
	@OneToMany(mappedBy="menuDetails",cascade = CascadeType.ALL)
	private List<CuisineDetails> cuisineDetails;
	
	private Integer isActive;

	public Long getMenuKey() {
		return menuKey;
	}

	public void setMenuKey(Long menuKey) {
		this.menuKey = menuKey;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuDescription() {
		return menuDescription;
	}

	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}

	public FoodOutletDetails getFoodOutletDetails() {
		return foodOutletDetails;
	}

	public void setFoodOutletDetails(FoodOutletDetails foodOutletDetails) {
		this.foodOutletDetails = foodOutletDetails;
	}

	public List<CuisineDetails> getCuisineDetails() {
		return cuisineDetails;
	}

	public void setCuisineDetails(List<CuisineDetails> cuisineDetails) {
		this.cuisineDetails = cuisineDetails;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	


	

}
