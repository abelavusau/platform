package com.platform.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.platform.web.model.User;
import com.platform.web.service.generic.GenericService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource(name = "userService")
    private GenericService<User> service;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
	model.addAttribute("users", service.loadAll());
	return "user";
    }
}
