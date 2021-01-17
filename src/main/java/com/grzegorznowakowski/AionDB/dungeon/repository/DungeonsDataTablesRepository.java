package com.grzegorznowakowski.AionDB.dungeon.repository;

import com.grzegorznowakowski.AionDB.dungeon.entity.DungeonEntity;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

/**
 * @author Grzegorz Nowakowski
 */
public interface DungeonsDataTablesRepository extends DataTablesRepository<DungeonEntity, Integer> {

    DataTablesOutput<DungeonEntity> findAll(DataTablesInput input);

}
