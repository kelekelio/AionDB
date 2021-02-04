package com.grzegorznowakowski.AionDB.toypet.repository;

import com.grzegorznowakowski.AionDB.toypet.entity.ToypetBuffEntity;
import com.grzegorznowakowski.AionDB.toypet.entity.ToypetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
@Repository
public interface ToypetRepository extends JpaRepository<ToypetEntity, Integer>, JpaSpecificationExecutor {
    Optional<ToypetEntity> findByName(String name);
}
