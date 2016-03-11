package com.psk.web;

import java.security.Principal;
import java.util.Map;

import com.psk.domain.AppUser;
import com.psk.domain.Employee;
import com.psk.manager.AppUserManager;
import com.psk.manager.EmployeeManager;
import com.psk.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.psk.service.PskService;

@Controller
public class PskController {
	private final Logger logger = LoggerFactory.getLogger(PskController.class);

	@Autowired
	private EmployeeManager employeeManager;

	@Autowired
	private AppUserManager appUserManager;

	@RequestMapping(value = "/open", method = RequestMethod.GET)
	public String openWindow(Map<String, Object> model) {
		return "window";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView model, Principal principal) {
		try {
			addMenuAndName(model, principal);
		} catch (Exception e) {
			addLogin(model);
		}
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/appuser",params = "form", method = RequestMethod.GET)
	public ModelAndView appUserCreate(ModelAndView model, Principal principal) {
		try {
			addMenuAndName(model, principal);
		} catch (Exception e) {

		}
		model.setViewName("appusers/create");
		return model;
	}

	@RequestMapping(value = "/appuser/list", method = RequestMethod.GET)
	public ModelAndView appUserList(ModelAndView model, Principal principal) {
		try {
			addMenuAndName(model, principal);
		} catch (Exception e) {

		}
		model.setViewName("appusers/list");
		return model;
	}

	@RequestMapping(value = "/appuser/edit/{id}", produces = "text/html")
	public ModelAndView engViewApprove(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
		try {
			model.addObject("appuser", appUserManager.findAppUser(id));
			addMenuAndName(model, principal);
		} catch (Exception e) {

		}
		model.setViewName("appusers/edit");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
							  @RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		addLogin(model);
		model.setViewName("login");
		return model;
	}

	private void addMenuAndName(ModelAndView model, Principal principal) {
		model.addObject("name", appUserManager.findAppUserByName(principal.getName()).getName());
		model.addObject("logout", "on");
		model.addObject("createUser", "on");
	}

	private void addLogin(ModelAndView model) {
		model.addObject("login", "on");
	}
}