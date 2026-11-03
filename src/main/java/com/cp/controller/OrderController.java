package com.cp.controller;

import com.cp.customexceptions.FoodOrderManagementServiceException;
import com.cp.dto.ResponseBean;
import com.cp.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private OrderService orderService;

}
