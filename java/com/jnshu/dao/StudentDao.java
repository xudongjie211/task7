package com.jnshu.dao;


import java.util.List;

import com.jnshu.pojo.Student;

public interface StudentDao {
	//增删改的返回值可以使void,boolean（操作是否成功）,int（受影响行数）
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
