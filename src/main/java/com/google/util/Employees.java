package com.google.util;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.model.Employee;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "employees")
public class Employees {
	
	@XmlElement(name="employee")
	private ArrayList<Employee> employees;

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
}
