package com.grzegorznowakowski.AionDB.toypet.repository;

import com.grzegorznowakowski.AionDB.toypet.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Integer>, JpaSpecificationExecutor {
    Optional<WarehouseEntity> findByName(String name);
}
