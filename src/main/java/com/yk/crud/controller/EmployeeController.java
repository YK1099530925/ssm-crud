package com.yk.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

	/**
	 * 查询员工数据（分页查询）
	 * */
	@RequestMapping(value="/emps")
	public String getEmps() {
		return "list";
	}
}
