package com.grzegorznowakowski.AionDB.items.repository;

import com.grzegorznowakowski.AionDB.db.entity.TranslationEntity;
import com.grzegorznowakowski.AionDB.items.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Grzegorz Nowakowski
 */
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {


}
