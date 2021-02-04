package com.grzegorznowakowski.AionDB.toypet.repository;

import com.grzegorznowakowski.AionDB.toypet.entity.ToypetWarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
public interface ToypetWarehouseRepository extends JpaRepository<ToypetWarehouseEntity, Integer>, JpaSpecificationExecutor {
    Optional<ToypetWarehouseEntity> findByName(String name);
}
