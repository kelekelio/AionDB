package com.grzegorznowakowski.AionDB.dungeon.controller;

import com.grzegorznowakowski.AionDB.items.object.ItemTypeObj;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Grzegorz Nowakowski
 */
@Controller
public class DungeonController {

    @RequestMapping(value = {"/dungeons"})
    public String listDungeons(Model model) {
        return "dungeons";
    }
}
