package com.grzegorznowakowski.AionDB.items.repository;

import com.grzegorznowakowski.AionDB.items.entity.ItemEntity;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Grzegorz Nowakowski
 */
public interface ItemDataTablesRepository extends DataTablesRepository<ItemEntity, Integer> {

}
