package com.dxh.po;

import java.io.Serializable;

public class Course implements Serializable{
	/**
	 * 课程持久化类
	 */
	private static final long serialVersionUID = 1L;
	private Integer course_id;
	private String course_name;
	private String course_tea;
	private	String course_point;
	private String course_time_1;
	private String course_time_2;
	private String course_limited;
	private	String course_count;
	private Integer start;			
	private Integer rows;		
	private String student_id;
	
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getCourse_count() {
		return course_count;
	}
	public void setCourse_count(String course_count) {
		this.course_count = course_count;
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
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_tea() {
		return course_tea;
	}
	public void setCourse_tea(String course_tea) {
		this.course_tea = course_tea;
	}
	public String getCourse_point() {
		return course_point;
	}
	public void setCourse_point(String course_point) {
		this.course_point = course_point;
	}
	public String getCourse_limited() {
		return course_limited;
	}
	public void setCourse_limited(String course_limited) {
		this.course_limited = course_limited;
	}
	public String getCourse_time_1() {
		return course_time_1;
	}
	public void setCourse_time_1(String course_time_1) {
		this.course_time_1 = course_time_1;
	}
	public String getCourse_time_2() {
		return course_time_2;
	}
	public void setCourse_time_2(String course_time_2) {
		this.course_time_2 = course_time_2;
	}
}
