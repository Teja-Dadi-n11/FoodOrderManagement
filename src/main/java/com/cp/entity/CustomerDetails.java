package com.cp.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customerdetails",schema="public")
public class CustomerDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long CusomerId;
	
	private String customerName;
	private String mobilenumber;
	private String dob;
	private Long subscriptionKey;
	private Integer isActive;
	
	@CreationTimestamp
	private Timestamp createdDate;

	@UpdateTimestamp
	private Timestamp lstUpdatedime;

	public Long getCusomerId() {
		return CusomerId;
	}

	public void setCusomerId(Long cusomerId) {
		CusomerId = cusomerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Long getSubscriptionKey() {
		return subscriptionKey;
	}

	public void setSubscriptionKey(Long subscriptionKey) {
		this.subscriptionKey = subscriptionKey;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLstUpdatedime() {
		return lstUpdatedime;
	}

	public void setLstUpdatedime(Timestamp lstUpdatedime) {
		this.lstUpdatedime = lstUpdatedime;
	}
	
	
	
	
	
	

}
