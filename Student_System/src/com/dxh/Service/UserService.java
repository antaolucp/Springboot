package com.dxh.Service;

import com.dxh.po.User;

public interface UserService {
	public User findUser(String usercode,String password,String checked);
	public int CreateUser(User user);
	public int DeleteUser(Integer id);
	public User getUserById(Integer id);
	public int updateUser(User user ,String password);
}
