package com.yk.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yk.crud.bean.DepartMent;
import com.yk.crud.dao.DepartMentMapper;

@Service
public class DepartMentService {

	@Autowired
	private DepartMentMapper departMentMapper;
	
	public List<DepartMent> getDepts() {
		List<DepartMent> depts = departMentMapper.selectByExample(null);
		return depts;
	}

}
