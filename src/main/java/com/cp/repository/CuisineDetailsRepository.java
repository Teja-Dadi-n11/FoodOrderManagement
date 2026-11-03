package com.cp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.entity.CuisineDetails;

public interface CuisineDetailsRepository extends JpaRepository<CuisineDetails, Long>{
	public List<CuisineDetails> findByCuisineNameAndIsActive(String cuisineName, Integer isActive);

	public List<CuisineDetails> findByCuisineKeyInAndIsActive(List<Long> cuisineKeys, Integer isActive);

	public CuisineDetails findByCuisineKeyAndIsActive(Long cuisineKey, Integer isActive);

}
