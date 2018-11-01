package com.jnshu.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jnshu.dao.CourseDao;
import com.jnshu.pojo.Course;


@Service
public class CourseImpl implements CourseInterface {
	private static ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static CourseDao cd=context.getBean(CourseDao.class);
	
	@Override
	public Course selectOne(int cid) {
		
		return cd.selectOne(cid);
	}

	@Override
	public List<Course> select() {
		// TODO Auto-generated method stub
		return cd.select();
	}

	@Override
	public long add(Course c) {
		// TODO Auto-generated method stub
		return cd.add(c);
	}

}
