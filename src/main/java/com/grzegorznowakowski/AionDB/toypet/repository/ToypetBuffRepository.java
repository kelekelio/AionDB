package com.grzegorznowakowski.AionDB.toypet.repository;

import com.grzegorznowakowski.AionDB.toypet.entity.ToypetBuffEntity;
import com.grzegorznowakowski.AionDB.toypet.entity.ToypetDopingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
@Repository
public interface ToypetBuffRepository  extends JpaRepository<ToypetBuffEntity, Integer>, JpaSpecificationExecutor {
    Optional<ToypetBuffEntity> findByName(String name);
}
