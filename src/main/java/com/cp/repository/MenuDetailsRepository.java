package com.cp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.entity.MenuDetails;

public interface MenuDetailsRepository extends JpaRepository<MenuDetails, Long> {
	public MenuDetails findByMenuKeyAndIsActive(Long menuKey, Integer isActive);


}
