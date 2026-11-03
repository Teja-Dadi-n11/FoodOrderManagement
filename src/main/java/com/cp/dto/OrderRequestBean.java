package com.cp.dto;

import java.util.List;

public class OrderRequestBean {

    private Long customerId;

    private String paymentmode;

    private Integer rewardspoints;

    private List<OrderBean> orderBeans;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
