package com.yk.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yk.crud.bean.Employee;
import com.yk.crud.bean.Msg;
import com.yk.crud.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/emps")
	@ResponseBody
	public Msg getEmpsJosn(@RequestParam(value="pageNum",defaultValue="1")Integer pageNum) {
		PageHelper.startPage(pageNum, 5);
		//startPage后面紧跟的这个查询，就是一个分页查询
		List<Employee> emps = employeeService.getAll();
		
		PageInfo pageInfo = new PageInfo(emps,5);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	/**
	 * 查询员工数据（分页查询）
	 * */
	@RequestMapping(value="/emps1")
	public String getEmps(@RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
			Model model) {
		/**
		 * 这是一个分页查询，引入pageHelper分页插件，
		 * 查询之前只需要调用，传入页码以及每页的大小
		 */
		PageHelper.startPage(pageNum, 5);
		//startPage后面紧跟的这个查询，就是一个分页查询
		List<Employee> emps = employeeService.getAll();
		
		PageInfo pageInfo = new PageInfo(emps,5);
		model.addAttribute("pageInfo", pageInfo);
		
		
		return "list";
	}
}
