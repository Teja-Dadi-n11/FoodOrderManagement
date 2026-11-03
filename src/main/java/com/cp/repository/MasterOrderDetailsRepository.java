package com.cp.repository;

import com.cp.entity.MasterOrderDetails;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MasterOrderDetailsRepository extends JpaRepository<MasterOrderDetails,Long> {
    public MasterOrderDetails findByMasterorderIdAndIsActive(Long masterOrderId,Integer isActive);
    public List<MasterOrderDetails> findByMasterIdInAndIsActive(List<Long> masterOrderId, Integer isActive);
}
