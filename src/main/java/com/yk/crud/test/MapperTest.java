package com.yk.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yk.crud.bean.DepartMent;
import com.yk.crud.bean.Employee;
import com.yk.crud.dao.DepartMentMapper;
import com.yk.crud.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {

	/**
	 * 测试DepartMentMapper
	 * */
	
	@Autowired
	DepartMentMapper mapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	SqlSession SqlSession;
	
	@Test
	public void testCRUD() {
		
		System.out.println(mapper);
		
		/*mapper.insertSelective(new DepartMent(null,"研发部"));
		mapper.insertSelective(new DepartMent(null,"测试部"));*/
		
		//employeeMapper.insertSelective(new Employee(null, "Jerry", "M", "jerry@163.com", 1));
		
		//批量插入
		EmployeeMapper mapper = SqlSession.getMapper(EmployeeMapper.class);
		
		for(int i = 0; i < 200; i++) {
			String uuid = UUID.randomUUID().toString().substring(0, 5) + i;
			mapper.insertSelective(new Employee(null, uuid, "M", uuid + "@163.com", 1));
		}
		System.out.println("批量完成");
	}

}
