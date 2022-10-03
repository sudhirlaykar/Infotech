package com.infomate.employee.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.infomate.employee.dte.Employee;
import com.infomate.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@Autowired
	ServletContext context;

	@GetMapping("/")
	public String showMain() {
		System.out.println("showmain called ");
		return "pagelayout/layout";
	}

	@GetMapping("/view")
	public String viewEmployees(Model model) {
		System.out.println("view employee called ");
		System.out.println("UserMockRepo.list " + service.findAllEmployee());
		model.addAttribute("employee", service.findAllEmployee());
		return "view";
	}

	@GetMapping("/add")
	public String addEmployeesView(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		System.out.println("add employee add called ");
		return "addEmployee";
	}

	@GetMapping("/update")
	public String updateEmployeesView() {
		System.out.println("add employee view called ");
		return "updateEmployee";

	}

	@GetMapping("/update/{id}")
	public String updateEmployeesView(@PathVariable("id") Integer id, Model model) {
		System.out.println("update employee view called id" + id);
		Employee emp = service.findEmployeeById(id);
		model.addAttribute("employee", emp);
		return "updateEmployee";

	}

	@PostMapping("/update")
	public String updateEmployees(@ModelAttribute("employee") Employee empl) {
		System.out.println("add employee view called id" + empl.getId());

		Employee emp = service.findEmployeeById(empl.getId());
		emp.setId(empl.getId());
		emp.setDepartment(empl.getDepartment());
		emp.setEmail(empl.getEmail());
		emp.setMobileNo(empl.getMobileNo());
		emp.setName(empl.getName());
		service.saveEmployee(emp);

		return "redirect:/view";

	}

	@GetMapping("/delete/{id}")
	public String deleteEmployeesView(@PathVariable("id") Integer id) {
		System.out.println("delete employee called id" + id);
		service.deleteEmployeeById(id);
		return "redirect:/view";

	}

	@PostMapping("/view")
	public String addEmployees(@ModelAttribute("employee") Employee empl, @RequestParam("imgpath") MultipartFile file) {
		System.out.println("add employee called " + empl);
		System.out.println("file name " + file.getOriginalFilename());

		// file storing logic
//src\main\resources\static\Images
		
		String filepath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
				+ File.separator + "resources" + File.separator + "static" + File.separator + "Images"+ File.separator
				+ file.getOriginalFilename();
		
		
		
		System.out.println("filename" + filepath);
		
		String absolutePath = context.getRealPath("resources/Images");
		System.out.println("absolutePath" + absolutePath);

		try (FileOutputStream fo = new FileOutputStream(new File(filepath))) {
			fo.write(file.getBytes());
			fo.flush();
			System.out.println("file written successfully ");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		empl.setImagePath(filepath);
		service.saveEmployee(empl);
		System.out.println("add employee called ");

		return "redirect:/view";
	}

}
