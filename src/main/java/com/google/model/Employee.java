package com.google.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlAttribute(name = "eno")
	private int eno;
	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "salary")
	private Double salary;
	@XmlAttribute(name = "uri")
	private String uri;

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", name=" + name + ", salary=" + salary + ", uri=" + uri + "]";
	}

	public Employee(int eno, String name, Double salary, String uri) {
		this.eno = eno;
		this.name = name;
		this.salary = salary;
		this.uri = uri;
	}

	public Employee() {
	}
}