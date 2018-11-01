package com.jnshu.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jnshu.dao.UserDao;
import com.jnshu.pojo.User;

@Service
public class UserImpl implements UserInterface {
		private static ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		private static UserDao ud=context.getBean(UserDao.class);
	
	@Override
	public long add(User u) {
		// TODO Auto-generated method stub
		return ud.add(u);
	}

	@Override
	public User selectOne(long uid) {
		// TODO Auto-generated method stub
		return ud.selectOne(uid);
	}

	@Override
	public List<User> select() {
		// TODO Auto-generated method stub
		return ud.select();
	}

	@Override
	public User findUser(User u) {
		// TODO Auto-generated method stub
		return ud.findUser(u);
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return ud.update(u);
	}

}
