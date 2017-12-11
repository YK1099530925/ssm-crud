package com.yk.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.yk.crud.bean.Employee;
import com.yk.crud.dao.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	
	/**
	 * 查询所有员工
	 * @return
	 */
	public List<Employee> getAll(@RequestParam(value="pageNumber",defaultValue="1")Integer pageNumber) {
		return employeeMapper.selectByExampleWithDept(null);
	}

}
