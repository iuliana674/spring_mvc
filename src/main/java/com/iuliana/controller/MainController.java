package com.iuliana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUsers(Model model){
        return "users";
    }
}
