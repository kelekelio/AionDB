package com.grzegorznowakowski.AionDB.toypet.repository;

import com.grzegorznowakowski.AionDB.toypet.entity.MerchantEntity;
import com.grzegorznowakowski.AionDB.toypet.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
public interface MerchantRepository extends JpaRepository<MerchantEntity, Integer>, JpaSpecificationExecutor {
    Optional<MerchantEntity> findByName(String name);
}
