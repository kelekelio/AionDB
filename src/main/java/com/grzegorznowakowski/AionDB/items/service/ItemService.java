package com.grzegorznowakowski.AionDB.items.service;

import com.grzegorznowakowski.AionDB.db.repository.TranslationRepository;
import com.grzegorznowakowski.AionDB.db.service.TranslationService;
import com.grzegorznowakowski.AionDB.items.entity.ItemEntity;
import com.grzegorznowakowski.AionDB.items.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

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

        Locale locale = LocaleContextHolder.getLocale();
        String code = locale.getLanguage();

        ItemEntity item = itemRepository.findById(id).get();

        //can not be null
        item.setDescription(
                translationService.findByName(item.getDescription()).getLocaString()
            );

        //can be null
        if (item.getDescLong() != null) {
            item.setDescLong(
                    translationService.findByName(item.getDescLong()).getLocaString()
            );
        }



        return item;
    }

    public List<ItemEntity> findByEquipmentSlots (String equipmentSlots) {
        return itemRepository.findAllByEquipmentSlots(equipmentSlots);
    }

    public List<ItemEntity> findByWeaponType (String weaponType) {
        return itemRepository.findAllByWeaponType(weaponType);
    }

    public List<ItemEntity> findAll() {
        return itemRepository.findAll();
    }

    public List<ItemEntity> findByArmorType(String slot) {
        return itemRepository.findAllByArmorType(slot);
    }

    public List<ItemEntity> findAllByIdBetween (Integer lowestId, Integer highestId) {
        return itemRepository.findAllByIdBetween(lowestId, highestId);
    }
}
