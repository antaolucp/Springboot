package com.dxh.dao;

import org.apache.ibatis.annotations.Param;

import com.dxh.po.User;

public interface UserDao {

	public User findUser(@Param("usercode") String usercode,
						 @Param("password") String password,
						 @Param("checked") String checked);
	public int CreateUser(User user);
	public int DeleteUser(Integer id);
	public User getUserById(Integer id);
	public int updateUser(@Param("user") User user,@Param("password")String password);
}
