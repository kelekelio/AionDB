package com.grzegorznowakowski.AionDB.quests.controller;

import com.grzegorznowakowski.AionDB.items.object.ItemObj;
import com.grzegorznowakowski.AionDB.quests.object.QuestObj;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Grzegorz Nowakowski
 */
@Controller
public class QuestController {

    @RequestMapping({"/qtext/{id}"})
    public String itemView(@PathVariable(value = "id") Integer id, Model model) {

        QuestObj quest = new QuestObj(id);

        model.addAttribute("quest", quest);
        return "quests/qtext";
    }
}
