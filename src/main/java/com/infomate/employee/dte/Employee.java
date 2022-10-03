package com.infomate.employee.dte;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String imagePath;
	private String email;
	private String mobileNo;
	private String department;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Employee(Integer id, String name, String email, String mobileNo, String department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.department = department;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}


	public String getImagePath() {
		return imagePath;
	}



	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", imagePath=" + imagePath + ", email=" + email + ", mobileNo="
				+ mobileNo + ", department=" + department + "]";
	}
	
	
	
	
	

}
