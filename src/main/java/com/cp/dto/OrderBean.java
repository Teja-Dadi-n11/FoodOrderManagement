package com.cp.dto;

import com.cp.customannotations.NotNull;

import java.math.BigDecimal;

public class OrderBean {

    @NotNull
    private String outletName;

    @NotNull
    private String outletBranchName;

    @NotNull
    private String cuisineName;

    private String paymentStatus;

    private BigDecimal price;

    public String getOutletBranchName() {
        return outletBranchName;
    }

    public void setOutletBranchName(String outletBranchName) {
        this.outletBranchName = outletBranchName;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
