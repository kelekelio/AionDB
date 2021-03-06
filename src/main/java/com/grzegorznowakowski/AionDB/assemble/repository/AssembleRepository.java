package com.grzegorznowakowski.AionDB.assemble.repository;

import com.grzegorznowakowski.AionDB.assemble.entity.AssembleEntity;
import com.grzegorznowakowski.AionDB.assemble.entity.AssemblePartsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
@Repository
public interface AssembleRepository extends JpaRepository<AssembleEntity, Integer>, JpaSpecificationExecutor {
    Optional<AssembleEntity> findByName(String name);
}
