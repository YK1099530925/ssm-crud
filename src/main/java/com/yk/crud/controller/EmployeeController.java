package com.yk.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yk.crud.bean.Employee;
import com.yk.crud.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	/**
	 * 查询员工数据（分页查询）
	 * */
	@RequestMapping(value="/emps")
	public String getEmps() {
		List<Employee> emps = employeeService.getAll();
		return "list";
	}
}
