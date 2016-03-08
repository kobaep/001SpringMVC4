package com.psk.web;

import java.util.Map;

import com.psk.domain.Employee;
import com.psk.manager.EmployeeManager;
import com.psk.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.psk.service.PskService;

@Controller
public class PskController {
	private final Logger logger = LoggerFactory.getLogger(PskController.class);

	@Autowired
	private EmployeeManager employeeManager;

	@RequestMapping(value = "/open", method = RequestMethod.GET)
	public String openWindow(Map<String, Object> model) {
		return "window";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		Employee employee = new Employee();
		employee.setName("Apichat");
		employee.setAge(24);
		employeeManager.insertEmployee(employee);
		logger.debug("-= emp {} =-", employeeManager.findAllEmployee().toString());
		return "index";
	}
}