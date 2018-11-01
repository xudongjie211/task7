package com.jnshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jnshu.dao.StudentDao;
import com.jnshu.pojo.Student;
import com.jnshu.redisstudent.RedisStudent;



@Service
public class StudentImpl implements StudentInterface {
		private static ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		private static StudentDao sd=context.getBean(StudentDao.class);
		
	@Autowired
	private RedisStudent rs;
		
	@Override
	public long add(Student u) {
		long b=sd.add(u);
		rs.addstringredis("allstudent", sd.select());
		return b;
	}

	@Override
	public boolean delete(long id) {
		
		return sd.delete(id);
	}

	@Override
	public boolean update(Student u) {
		// TODO Auto-generated method stub
		return sd.update(u);
	}

	@Override
	public Student selectOne(long id) {
		// TODO Auto-generated method stub
		return sd.selectOne(id);
	}

	@Override
	public List<Student> select() {
		if(rs.getstringredis("allstudent")!=null){
			return (List<Student>)rs.getstringredis("allstudent");						
		}else{
			rs.addstringredis("allstudent", sd.select());
			return sd.select();	
		}

	}

	@Override
	public List<Student> selectLike(String name) {
		// TODO Auto-generated method stub
		return sd.selectLike(name);
	}

	@Override
	public int count() {
		if(rs.getstringredis("num")!=null){		
			return (Integer)rs.getstringredis("num");
		}else{
			rs.addstringredis("num", sd.count());
			return sd.count();	
		}
		
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return sd.deleteAll();
	}

	@Override
	public boolean back1() {
		// TODO Auto-generated method stub
		return sd.back1();
	}

	@Override
	public Student selectLogin(Student u) {
		// TODO Auto-generated method stub
		return sd.selectLogin(u);
	}

	@Override
	public Student findByname(String name) {
		// TODO Auto-generated method stub
		return sd.findByname(name);
	}

	@Override
	public Student findByphone(String phone) {
		
		return sd.findByphone(phone);
	}

	@Override
	public void updateImage(Student u) {
		sd.updateImage(u);
		
	}

	@Override
	public Student findByCode(String code) {
		// TODO Auto-generated method stub
		return sd.findByCode(code);
	}

}
