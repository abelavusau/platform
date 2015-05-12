package com.platform.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.platform.web.model.User;

@Controller
@RequestMapping(value = "/examples")
public class ExamplesController {
    @RequestMapping(value = "gridster", method = RequestMethod.GET)
    public String gridster(Model model) {
	model.addAttribute(new User());
	return "examples/gridster";
    }
}
