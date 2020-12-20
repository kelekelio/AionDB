package com.grzegorznowakowski.AionDB.items.service;

import com.grzegorznowakowski.AionDB.db.repository.TranslationRepository;
import com.grzegorznowakowski.AionDB.db.service.TranslationService;
import com.grzegorznowakowski.AionDB.items.entity.ItemEntity;
import com.grzegorznowakowski.AionDB.items.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

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
        item.setDescription(
                translationService.findByName(item.getDescription()).getLocaString(code)
            );
        item.setDescLong(
                translationService.findByName(item.getDescLong()).getLocaString(code)
            );


        return item;
    }

}
