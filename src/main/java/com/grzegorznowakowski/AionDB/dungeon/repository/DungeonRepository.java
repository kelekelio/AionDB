package com.grzegorznowakowski.AionDB.dungeon.repository;

import com.grzegorznowakowski.AionDB.dungeon.entity.DungeonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Grzegorz Nowakowski
 */
@Repository
public interface DungeonRepository extends JpaRepository<DungeonEntity, Integer> {

    List<DungeonEntity> findAll();


}
