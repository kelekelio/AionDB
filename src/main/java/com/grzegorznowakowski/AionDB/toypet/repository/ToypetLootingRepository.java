package com.grzegorznowakowski.AionDB.toypet.repository;

import com.grzegorznowakowski.AionDB.toypet.entity.ToypetLootingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
@Repository
public interface ToypetLootingRepository extends JpaRepository<ToypetLootingEntity, Integer>, JpaSpecificationExecutor {
    Optional<ToypetLootingEntity> findByName(String name);
}
