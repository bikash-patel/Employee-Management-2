package com.bikash.service;

import java.util.List;

import com.bikash.model.Employee;

public interface IEmployeeService {
	public List<Employee> employeeDetails();
	public Employee getEmployeeDetails(String empid);
	public int employeeDetailsUpdate(Employee emp);
	public int deleteEmployee(String empid);
	public int employeeInsert(Employee emp);
}
