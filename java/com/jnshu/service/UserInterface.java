package com.jnshu.service;

import java.util.List;

import com.jnshu.pojo.User;

public interface UserInterface {
	public long add(User u);
	public User selectOne(long uid);
	public List<User> select();
	public User findUser(User u);
	public boolean update(User u);
}
