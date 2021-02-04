package com.grzegorznowakowski.AionDB.familiars.repository;


import com.grzegorznowakowski.AionDB.familiars.entity.FamiliarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
@Repository
public interface FamiliarRepository extends JpaRepository<FamiliarEntity, Integer>, JpaSpecificationExecutor {
    Optional<FamiliarEntity> findByName(String name);
}
