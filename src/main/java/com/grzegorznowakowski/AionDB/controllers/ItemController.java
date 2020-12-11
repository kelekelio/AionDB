package com.grzegorznowakowski.AionDB.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Grzegorz Nowakowski
 */
@Controller
public class ItemController {


    @RequestMapping({"/items/{type}"})
    public String listItems(@PathVariable("type") String type, Model model) {


        return "items";
    }

}
