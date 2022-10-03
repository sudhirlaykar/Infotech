package com.infomate.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infomate.employee.dte.Employee;
import com.infomate.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository er;

	public void saveEmployee(Employee emp) {
		er.save(emp);
		
	}

	public Employee findEmployeeById(Integer id) {
		Optional<Employee> op = er.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			return null;
		}
	}

	public List<Employee> findAllEmployee() {
		return er.findAll();
	}

	public void deleteEmployeeById(Integer id) {
		er.deleteById(id);
	}

	public void updateEmployeeById(Employee emp) {
		er.save(emp);
	}
}
