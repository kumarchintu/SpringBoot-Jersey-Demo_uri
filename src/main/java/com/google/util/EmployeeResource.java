package com.google.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.model.Employee;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "employees")
@Path("/employees")
public class EmployeeResource {

	private static Map<Integer, Employee> empMap = new HashMap<>();

	@GET
	@Produces("application/json")
	public Employees getAllEmployees() {
		Employees employees = new Employees();
		employees.setEmployees(new ArrayList<>(empMap.values()));
		return employees;
	}

	@POST
	@Consumes("application/json")
	public Response createEmployee(Employee employee) throws URISyntaxException {
		if (employee.getName() == null) {
			return Response.status(400).entity("Please fill in all required fields").build();
		}
		employee.setEno(empMap.values().size() + 1);
		employee.setUri("/employee-management/" + employee.getEno());
		empMap.put(employee.getEno(), employee);
		return Response.status(201).contentLocation(new URI(employee.getUri())).build();
	}

	@GET
	@Path("/{eno}")
	@Produces("application/json")
	public Response getEmployeeByEno(@PathParam("eno") int eno) throws URISyntaxException {
		Employee employee = empMap.get(eno);
		if (employee == null)
			return Response.status(404).build();
		return Response.status(200).entity(employee).contentLocation(new URI("/employee-management/" + eno)).build();
	}

	@PUT
	@Path("/{eno}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateEmployee(@PathParam("eno") int eno, Employee employee) {
		Employee tempEmployee = empMap.get(eno);
		if (employee == null)
			return Response.status(404).build();
		tempEmployee.setName(employee.getName());
		tempEmployee.setSalary(employee.getSalary());
		empMap.put(tempEmployee.getEno(), tempEmployee);
		return Response.status(200).entity(tempEmployee).build();
	}

	@DELETE
	@Path("/{eno}")
	public Response deleteEmployee(@PathParam("eno") int eno) {
		Employee employee = empMap.get(eno);
		if (employee != null) {
			empMap.remove(employee.getEno());
			return Response.status(200).build();
		}
		return Response.status(404).build();
	}

	static {
		Employee employee1 = new Employee(1, "Abhishek", 60000d, "/employee-management/1");
		Employee employee2 = new Employee(2, "Rashmi", 65000d, "/employee-management/2");
		
		empMap.put(employee1.getEno(), employee1);
		empMap.put(employee2.getEno(), employee2);
	}
}
