package com.grzegorznowakowski.AionDB.toypet.repository;

import com.grzegorznowakowski.AionDB.toypet.entity.ToypetDopingEntity;
import com.grzegorznowakowski.AionDB.toypet.entity.ToypetFeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
@Repository
public interface ToypetDopingRepository extends JpaRepository<ToypetDopingEntity, Integer>, JpaSpecificationExecutor {
    Optional<ToypetDopingEntity> findByName(String name);
}
