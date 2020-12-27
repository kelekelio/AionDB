package com.grzegorznowakowski.AionDB.items.repository;

import com.grzegorznowakowski.AionDB.db.entity.TranslationEntity;
import com.grzegorznowakowski.AionDB.items.entity.ItemEntity;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Grzegorz Nowakowski
 */
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {


    List<ItemEntity> findAllByEquipmentSlots(String quipmentSlots);

    List<ItemEntity> findAllByWeaponType(String weaponType);

    List<ItemEntity> findAllByArmorType(String slot);

    List<ItemEntity> findAllByIdBetween (Integer lowestId, Integer highestId);
}
