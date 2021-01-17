package com.grzegorznowakowski.AionDB.items.repository;

import com.grzegorznowakowski.AionDB.items.entity.ItemEntity;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

/**
 * @author Grzegorz Nowakowski
 */
public interface ItemDataTablesRepository extends DataTablesRepository<ItemEntity, Integer> {

}
