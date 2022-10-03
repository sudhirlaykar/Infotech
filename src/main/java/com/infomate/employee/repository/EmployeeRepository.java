package com.infomate.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infomate.employee.dte.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	
	
}
