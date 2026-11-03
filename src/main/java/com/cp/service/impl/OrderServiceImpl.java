package com.cp.service.impl;

import com.cp.dto.OrderRequestBean;
import com.cp.dto.ResponseBean;
import com.cp.repository.MasterOrderDetailsRepository;
import com.cp.repository.MenuDetailsRepository;
import com.cp.repository.OrderDetailsRepository;
import com.cp.repository.OutletDetailsRepository;
import com.cp.service.OrderService;

public class OrderServiceImpl implements OrderService {

    private final OutletDetailsRepository outletDetailsRepository;
    private final MasterOrderDetailsRepository masterOrderDetailsRepository;
    private final MenuDetailsRepository menuDetailsRepository;
    private final OrderDetailsRepository orderDetailsRepository;

    public OrderServiceImpl(OutletDetailsRepository outletDetailsRepository, MasterOrderDetailsRepository masterOrderDetailsRepository, MenuDetailsRepository menuDetailsRepository, OrderDetailsRepository orderDetailsRepository) {
        this.outletDetailsRepository = outletDetailsRepository;
        this.masterOrderDetailsRepository = masterOrderDetailsRepository;
        this.menuDetailsRepository = menuDetailsRepository;
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public ResponseBean fetchOrderDetails(String customerId) {
        return null;
    }

    @Override
    public ResponseBean placeOrder(OrderRequestBean orderRequestBean) {
        return null;
    }
}
