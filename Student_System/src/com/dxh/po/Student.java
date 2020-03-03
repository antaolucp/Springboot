package com.dxh.po;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 学生持久化类
	 */
	private static final long serialVersionUID = 1L;
	private Integer student_id;		//学号
	private String student_name;	//姓名
	private String student_sex;		//性别
	private	String student_nation;	//民族
	private String student_birth;	//出生日期
	private String student_major;	//专业
	private String student_grade;	//年级
	private String student_place;	//籍贯
	private String student_tie;		//系别
	private	String student_count;	//学生总数
	private Integer start;			//起始行
	private Integer rows;			//所取行
	
	public String getStudent_birth() {
		return student_birth;
	}
	public void setStudent_birth(String student_birth) {
		this.student_birth = student_birth;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_sex() {
		return student_sex;
	}
	public void setStudent_sex(String student_sex) {
		this.student_sex = student_sex;
	}
	public String getStudent_nation() {
		return student_nation;
	}
	public void setStudent_nation(String student_nation) {
		this.student_nation = student_nation;
	}
	public String getStudent_tie() {
		return student_tie;
	}
	public void setStudent_tie(String student_tie) {
		this.student_tie = student_tie;
	}
	public String getStudent_major() {
		return student_major;
	}
	public void setStudent_major(String student_major) {
		this.student_major = student_major;
	}
	public String getStudent_grade() {
		return student_grade;
	}
	public void setStudent_grade(String student_grade) {
		this.student_grade = student_grade;
	}
	public String getStudent_place() {
		return student_place;
	}
	public void setStudent_place(String student_place) {
		this.student_place = student_place;
	}
	public String getStudent_count() {
		return student_count;
	}
	public void setStudent_count(String student_count) {
		this.student_count = student_count;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	

}
