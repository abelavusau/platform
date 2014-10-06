package com.platform.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.platform.web.model.Role;
import com.platform.web.model.User;
import com.platform.web.service.generic.GenericService;

@Controller
@SessionAttributes(types = User.class)
@RequestMapping(value = "/registration")
public class RegistrationController {

    @Resource(name = "userService")
    private GenericService<User> userService;

    @Resource(name = "roleService")
    private GenericService<Role> roleService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
	model.addAttribute(new User());
	return "login/registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerUser(@ModelAttribute(value = "user") User user, BindingResult bindingResult) {
	List<Role> roles = roleService.loadAll();
	user.getRoles().add(roles.get(1)); // set role to ROLE_USER
	user.setEnabled(true);
	userService.create(user);
	return "redirect:/registration/success";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String registerSuccess(@ModelAttribute(value = "user") User user, SessionStatus status) {
	status.setComplete();
	return "login/success";
    }
}