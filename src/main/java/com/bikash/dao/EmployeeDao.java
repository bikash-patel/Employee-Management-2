package com.bikash.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bikash.model.Employee;

@Repository
public class EmployeeDao implements IEmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static String cmd="select * from employeedetails";
	private static String empFetchById="select * from employeedetails where empid=?";
	private static String empUpdate="update employeedetails set firstname=?,lastname=?,emailid=? where empid=?";
	private static String deleteEmployee="delete from employeedetails where empid=?";
	private static String insertEmployee="insert into employeedetails(firstname,lastname,empid,emailid) values(?,?,?,?)";
	@Override
	public List<Employee> getDetails() {
		List<Employee> list=jdbcTemplate.query(cmd,rs-> {
									List<Employee> list1=new ArrayList<Employee>();
			                        while(rs.next())
			                        {
			                        	Employee emp=new Employee();
			                        	emp.setFirstname(rs.getString(1));
			                        	emp.setLastname(rs.getString(2));
			                        	emp.setEmpid(rs.getInt(3));
			                        	emp.setEmailid(rs.getString(4));
			                        	list1.add(emp);
			                        }
			                        return list1;
		});
		return list;
	}

	@Override
	public Employee filterEmployeeById(String empid) {
		Employee list=(Employee) jdbcTemplate.queryForObject(empFetchById,(rs,rowNum)->{
			                                              Employee emp=new Employee();
			                                              emp.setFirstname(rs.getString(1));
			                                              emp.setLastname(rs.getString(2));
			      			                        	  emp.setEmpid(rs.getInt(3));
			      			                        	  emp.setEmailid(rs.getString(4));
			      			                        	  return emp;
		},empid);
		return list;
	}

	@Override
	public int updateEmployeeData(Employee emp) {
        int count=jdbcTemplate.update(empUpdate,emp.getFirstname(),emp.getLastname(),emp.getEmailid(),emp.getEmpid());
		return count;
	}

	@Override
	public int employeeRemoval(String empid) {
		int count=jdbcTemplate.update(deleteEmployee,empid);
		return count;
	}

	@Override
	public int addEmployee(Employee emp) {
       int count=jdbcTemplate.update(insertEmployee,emp.getFirstname(),emp.getLastname(),emp.getEmpid(),emp.getEmailid());
		return count;
	}
}
