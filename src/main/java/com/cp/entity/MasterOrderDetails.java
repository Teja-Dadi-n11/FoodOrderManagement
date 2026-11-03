package com.cp.entity;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="masterorderdetails",schema="public")
public class MasterOrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long masterorderId;
	
	@OneToMany(mappedBy = "masterOrderDetails",cascade = CascadeType.ALL)
	private List<OrderDetails> orderDetails;
	
	private Long customerId;
	private String orderstatus;
	private String transactionId;
	private Integer isActive;
    
	@CreationTimestamp
	private Timestamp createdTime;
	
	@UpdateTimestamp
	private Timestamp lstUpdatedStamp;

	public Long getMasterorderId() {
		return masterorderId;
	}

	public void setMasterorderId(Long masterorderId) {
		this.masterorderId = masterorderId;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderdetails) {
		this.orderDetails = orderDetails;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Timestamp getLstUpdatedStamp() {
		return lstUpdatedStamp;
	}

	public void setLstUpdatedStamp(Timestamp lstUpdatedStamp) {
		this.lstUpdatedStamp = lstUpdatedStamp;
	}
	
	

}
