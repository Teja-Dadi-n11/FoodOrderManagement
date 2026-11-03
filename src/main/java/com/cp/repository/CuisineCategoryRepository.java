package com.cp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.entity.CuisineCategory;

public interface CuisineCategoryRepository extends JpaRepository<CuisineCategory, Long> {
	public CuisineCategory findByCuisineCateCodeAndIsActive(String cuisineCateCode, Integer isActive);

}
