package com.grzegorznowakowski.AionDB.assemble.repository;

import com.grzegorznowakowski.AionDB.assemble.entity.AssembleEntity;
import com.grzegorznowakowski.AionDB.assemble.entity.AssemblePartsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author Grzegorz Nowakowski
 */
public interface AssemblePartsRepository extends JpaRepository<AssemblePartsEntity, Integer>, JpaSpecificationExecutor {

    List<AssemblePartsEntity> findAllByName(String name);
    List<AssemblePartsEntity> findAllByPartItem(String name);
}
