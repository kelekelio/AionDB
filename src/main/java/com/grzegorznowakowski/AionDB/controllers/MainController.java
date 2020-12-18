package com.grzegorznowakowski.AionDB.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author Grzegorz Nowakowski
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        return "index";
    }
}
