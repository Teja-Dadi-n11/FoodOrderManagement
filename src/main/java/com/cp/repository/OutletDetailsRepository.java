package com.cp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.entity.FoodOutletDetails;

public interface OutletDetailsRepository extends JpaRepository<FoodOutletDetails, Long> {
	
	public FoodOutletDetails findByOutletNameAndBranchNameAndIsActive(String outletName,String branch,Integer isActive);
	
	public List<FoodOutletDetails> findByOutletKeyInAndIsActive(List<Long> outletKeys,Integer isActive);
	
	public FoodOutletDetails findByOutletKeyAndIsActive(Long OutletKey,Integer isActive);

	public FoodOutletDetails findByOutletNameAndOutletCode(String outletName,String outletCode);

}
