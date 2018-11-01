package com.jnshu.dao;

import java.util.List;

import com.jnshu.pojo.User;

public interface UserDao {
	public long add(User u);
	public User selectOne(long uid);
	public List<User> select();
	public User findUser(User u);
	public boolean update(User u);
}
