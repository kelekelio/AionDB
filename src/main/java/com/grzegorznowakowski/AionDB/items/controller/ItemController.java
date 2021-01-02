package com.grzegorznowakowski.AionDB.items.controller;

import com.grzegorznowakowski.AionDB.db.service.TranslationService;
import com.grzegorznowakowski.AionDB.items.object.ItemTypeObj;
import com.grzegorznowakowski.AionDB.items.object.ItemObj;
import com.grzegorznowakowski.AionDB.items.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Grzegorz Nowakowski
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private TranslationService translationService;




    @RequestMapping({"/item/{id}"})
    public String itemView(@PathVariable(value = "id") Integer id, Model model) {

        ItemObj itemObj = new ItemObj();
        itemObj.setItemEntity(itemService.get(id));
        itemObj.buildItem(translationService);
        model.addAttribute("item", itemObj);


        return "items/item";
    }

    @RequestMapping({"/tooltip/{id}"})
    public String itemTooltipView(@PathVariable(value = "id") Integer id, Model model) {

        ItemObj itemObj = new ItemObj();
        itemObj.setItemEntity(itemService.get(id));
        itemObj.buildItem(translationService);
        model.addAttribute("item", itemObj);


        return "items/item";
    }


    @RequestMapping(value = {"/items/{type}"})
    public String listItems(@PathVariable("type") String type, Model model) {

        ItemTypeObj itemType = new ItemTypeObj(type);

        model.addAttribute("itemType", itemType);

        return "items";
    }



}
