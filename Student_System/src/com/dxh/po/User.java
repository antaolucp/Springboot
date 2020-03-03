package com.dxh.po;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 用户持久化类
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String usercode;
	private String username;
	private String password;
	private String checked;
	private Integer Student_id;
	public Integer getStudent_id() {
		return Student_id;
	}
	public void setStudent_id(Integer student_id) {
		Student_id = student_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
