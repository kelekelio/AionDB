package com.grzegorznowakowski.AionDB.assemble.repository;

import com.grzegorznowakowski.AionDB.assemble.entity.AssembleEntity;
import com.grzegorznowakowski.AionDB.assemble.entity.AssemblePartsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
public interface AssembleRepository extends JpaRepository<AssembleEntity, Integer> {
    Optional<AssembleEntity> findByName(String name);
}
