package com.cp.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orderdetails",schema="public")
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private Long restaurntKey;
	private Long cuisineKey;
	private Long orderBy;
	
	private Integer quantity;   //I added this field
	@ManyToOne
	@JoinColumn(name="masterorderId",nullable=false)
	private MasterOrderDetails orderDetails;
	
	private String status;

	private Integer isActive;

	private BigDecimal price;

	private BigDecimal discount;
	
	private Timestamp orderCreateddateTime;

	private Timestamp lstUpdatedDateTime;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getRestaurntKey() {
		return restaurntKey;
	}

	public void setRestaurntKey(Long restaurntKey) {
		this.restaurntKey = restaurntKey;
	}

	public Long getCuisineKey() {
		return cuisineKey;
	}

	public void setCuisineKey(Long cuisineKey) {
		this.cuisineKey = cuisineKey;
	}

	public Long getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Long orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public MasterOrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(MasterOrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Timestamp getOrderCreateddateTime() {
		return orderCreateddateTime;
	}

	public void setOrderCreateddateTime(Timestamp orderCreateddateTime) {
		this.orderCreateddateTime = orderCreateddateTime;
	}

	public Timestamp getLstUpdatedDateTime() {
		return lstUpdatedDateTime;
	}

	public void setLstUpdatedDateTime(Timestamp lstUpdatedDateTime) {
		this.lstUpdatedDateTime = lstUpdatedDateTime;
	}
	
	
}
