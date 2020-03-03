package com.dxh.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxh.Service.UserService;
import com.dxh.dao.UserDao;
import com.dxh.po.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public User findUser(String usercode, String password, String checked) {
		User user =this.userDao.findUser(usercode,password, checked);
		return user;
	}
	@Override
	public int CreateUser(User user) {
		// TODO 自动生成的方法存根
		return userDao.CreateUser(user);
	}
	@Override
	public int DeleteUser(Integer id) {
		// TODO 自动生成的方法存根
		return userDao.DeleteUser(id);
	}
	@Override
	public User getUserById(Integer id) {
		// TODO 自动生成的方法存根
		User user = userDao.getUserById(id);
		return user;
	}
	@Override
	public int updateUser(User user,String password) {
		// TODO 自动生成的方法存根
		return userDao.updateUser(user,password);
	}
	
}
