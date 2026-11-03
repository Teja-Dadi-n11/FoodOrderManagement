package com.cp.service;


import com.cp.dto.OrderRequestBean;
import com.cp.dto.ResponseBean;

public interface OrderService {
    public ResponseBean fetchOrderDetails(String customerId);

    public ResponseBean placeOrder(OrderRequestBean orderRequestBean);

}
