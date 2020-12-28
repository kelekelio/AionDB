package com.grzegorznowakowski.AionDB.items.controller;

import com.grzegorznowakowski.AionDB.db.service.TranslationService;
import com.grzegorznowakowski.AionDB.items.entity.ItemEntity;
import com.grzegorznowakowski.AionDB.items.entity.ItemTypeObj;
import com.grzegorznowakowski.AionDB.items.repository.ItemRepository;
import com.grzegorznowakowski.AionDB.items.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * @author Grzegorz Nowakowski
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private TranslationService translationService;

    private final Locale locale = LocaleContextHolder.getLocale();
    private final String code = locale.getLanguage();


    @RequestMapping({"/item/{id}"})
    public String itemView(@PathVariable(value = "id") Integer id, Model model) {

        try {
            ItemEntity item = itemService.get(id);
            model.addAttribute("item", item);
        } catch (NoSuchElementException e){
            ItemEntity item = new ItemEntity();
            model.addAttribute("item", item);
        }


        return "item";
    }

    @RequestMapping({"/tooltip/{id}"})
    public String itemTooltipView(@PathVariable(value = "id") Integer id, Model model) {

        try {
            ItemEntity item = itemService.get(id);
            model.addAttribute("item", item);
        } catch (NoSuchElementException e){
            ItemEntity item = new ItemEntity();
            model.addAttribute("item", item);
        }


        return "items/item";
    }


    @RequestMapping(value = {"/items/{type}"})
    public String listItems(@PathVariable("type") String type, Model model) {

        ItemTypeObj itemType = new ItemTypeObj(type);

        model.addAttribute("itemType", itemType);

        return "items";
    }



}
