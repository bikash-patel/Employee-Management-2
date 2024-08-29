package com.bikash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.dao.IEmployeeDao;
import com.bikash.model.Employee;

@Service("empService")
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeDao empDao;
	@Override
	public List<Employee> employeeDetails() {
		List<Employee> list=empDao.getDetails();
		return list;
	}
	@Override
	public Employee getEmployeeDetails(String empid) {
		Employee list=empDao.filterEmployeeById(empid);
		return list;
	}
	@Override
	public int employeeDetailsUpdate(Employee emp) {
		int count=empDao.updateEmployeeData(emp);
		return count;
	}
	@Override
	public int deleteEmployee(String empid) {
		int count=empDao.employeeRemoval(empid);
		return count;
	}
	@Override
	public int employeeInsert(Employee emp) {
		int count=empDao.addEmployee(emp);
		return count;
	}

}
