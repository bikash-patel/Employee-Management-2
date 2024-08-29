package com.bikash.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bikash.model.Employee;
import com.bikash.service.IEmployeeService;

@Controller
public class EmployerOperationalController {
	
	@Autowired
	private IEmployeeService empService;
	@GetMapping("/")
	public String studentHome()
	{
		return "welcome";
	}
	
	@GetMapping("/report")
	public String studentDetails(Map<String,Object> map)
	{
		List<Employee> list=empService.employeeDetails();
		map.put("details", list);
		System.out.println(list);
		return "employee_details";
	}
	
	@GetMapping("/edit_form")
	public String editForm(@RequestParam("empid") String empid,@ModelAttribute("emp") Employee emp)
	{
		 Employee emp1= empService.getEmployeeDetails(empid);
		 BeanUtils.copyProperties(emp1, emp);
			return "employee_edit_form";
	}
	@PostMapping("/update_data")
	public String editEmpDetails(@ModelAttribute("emp") Employee emp,Map<String,Object> map)
	{
		int count=empService.employeeDetailsUpdate(emp);
		String msg=(count==0) ?"Data not found for updation":"Employee details updated";
		List<Employee> list=empService.employeeDetails();
		map.put("details", list);
		map.put("msg", msg);
		System.out.println(list);
		return "employee_details";
	}
	@GetMapping("/delete")
	public String empDelete(@RequestParam("empid") String empid,Map<String,Object> map)
	{
		int count=empService.deleteEmployee(empid);
		String msg=(count==0)?"Not record found for deletion":"Employee deleted";
		List<Employee> list=empService.employeeDetails();
		map.put("details", list);
		map.put("msg", msg);
		System.out.println(list);
		return "employee_details";
	}
	
	@GetMapping("/register")
	public String empAdd()
	{
		return "registeremployee";
	}
	@GetMapping("/inserting")
	public String empInserting(@ModelAttribute("emp") Employee emp,RedirectAttributes attr)
	{
		int count=empService.employeeInsert(emp);
		String msg=(count==0)?"Employee not inserted":"Employee register successfully!";
		attr.addFlashAttribute("msg",msg);
		return "redirect:report";
	}
}

