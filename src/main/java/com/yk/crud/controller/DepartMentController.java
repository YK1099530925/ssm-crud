package com.yk.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yk.crud.bean.DepartMent;
import com.yk.crud.bean.Msg;
import com.yk.crud.service.DepartMentService;

@Controller
public class DepartMentController {
	
	@Autowired
	private DepartMentService departMentService;
	
	/**
	 * 返回所有部门信息
	 * @return
	 */
	@RequestMapping(value="/depts")
	@ResponseBody
	public Msg getDepts() {
		List<DepartMent> depts = departMentService.getDepts();
		return Msg.success().add("depts", depts);
	}
}
