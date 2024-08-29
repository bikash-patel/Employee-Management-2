package com.bikash.dao;

import java.util.List;

import com.bikash.model.Employee;

public interface IEmployeeDao {
	public List<Employee> getDetails();
	public Employee filterEmployeeById(String empid);
	public int updateEmployeeData(Employee emp);
	public int employeeRemoval(String empid);
	public int addEmployee(Employee emp);
}
