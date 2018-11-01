package com.jnshu.service;

import java.util.List;

import com.jnshu.pojo.Student;

public interface StudentInterface {
	public long add(Student u);
	public boolean delete(long id);
	public boolean update(Student u);
	public Student selectOne(long id);
	public Student selectLogin(Student u);
	public List<Student> select();//总表查询
	public List<Student> selectLike(String name);//模糊查询
	public int count();//记录条数
	public boolean deleteAll();
	public boolean back1();
	public Student findByname(String name);
	public Student findByphone(String phone);
	public void updateImage(Student u);
	public Student findByCode(String code);
}
