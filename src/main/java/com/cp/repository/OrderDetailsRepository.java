package com.cp.repository;

import com.cp.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {

    public List<OrderDetails> findByOrderIdAndIsActive(Long orderId,Integer isActive);

    public List<OrderDetails> findByOrderByAndIsActive(Long orderedBy, Integer isActive);
}
