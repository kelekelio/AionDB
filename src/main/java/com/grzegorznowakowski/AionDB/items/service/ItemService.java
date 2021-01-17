package com.grzegorznowakowski.AionDB.items.service;

import com.grzegorznowakowski.AionDB.translation.repository.TranslationRepository;
import com.grzegorznowakowski.AionDB.translation.service.TranslationService;
import com.grzegorznowakowski.AionDB.items.entity.ItemEntity;
import com.grzegorznowakowski.AionDB.items.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Grzegorz Nowakowski
 */
@Service
public class ItemService {


    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private TranslationRepository translationRepository;

    @Autowired
    private TranslationService translationService;

    public ItemEntity get(Integer id) {
        return itemRepository.findById(id).get();
    }

    public List<ItemEntity> findByEquipmentSlots (String equipmentSlots) {
        return itemRepository.findAllByEquipmentSlots(equipmentSlots);
    }

    public List<ItemEntity> findByWeaponType (String weaponType) {
        return itemRepository.findAllByWeaponType(weaponType);
    }



    public List<ItemEntity> findByArmorType(String slot) {
        return itemRepository.findAllByArmorType(slot);
    }

    public List<ItemEntity> findAllByIdBetween (Integer lowestId, Integer highestId) {
        return itemRepository.findAllByIdBetween(lowestId, highestId);
    }
}
