package com.grzegorznowakowski.AionDB.toypet.repository;

import com.grzegorznowakowski.AionDB.toypet.entity.ToypetMerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
public interface ToypetMerchantRepository extends JpaRepository<ToypetMerchantEntity, Integer>, JpaSpecificationExecutor {
    Optional<ToypetMerchantEntity> findByName(String name);
}
