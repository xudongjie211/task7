package com.jnshu.dao;

import java.util.List;

import com.jnshu.pojo.Course;

public interface CourseDao {
	public Course selectOne(int cid);
	public List<Course> select();
	public long add(Course c);
	
}
