package com.ali.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ali.thymeleaf.entity.Employee;
import com.ali.thymeleaf.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		List<Employee> employees = employeeService.findAll();
		
		model.addAttribute("employees", employees);
		return "employee/list-employees";
	}
	
	@GetMapping("/add")
	public String addEmployee(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		return "employee/add-employee";
	}
	
	@GetMapping("/updateEmployee")
	public String updateEmployee(@RequestParam("employeeId") Integer id, Model model) {
		
		Employee employee = employeeService.findById(id);
		model.addAttribute(employee);
		
		return "employee/add-employee";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		employeeService.save(employee);
		return "redirect:/employees/list";
		
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") Integer id) {
		
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
	
}
