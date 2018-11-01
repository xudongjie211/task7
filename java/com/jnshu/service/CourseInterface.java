package com.jnshu.service;

import java.util.List;

import com.jnshu.pojo.Course;

public interface CourseInterface {
	public Course selectOne(int cid);
	public List<Course> select();
	public long add(Course c);
	
}
