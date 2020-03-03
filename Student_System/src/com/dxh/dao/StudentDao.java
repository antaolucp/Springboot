package com.dxh.dao;

import java.util.List;

import com.dxh.po.Student;

public interface StudentDao {
	public List<Student> selectStudentList(Student student);
	public Integer selectStudentListCount(Student student);
	public int createStudent(Student student);
	public Student getStudentById(Integer id);
	public int updateStudent(Student student);
	public int deleteStudent(Integer id);
}
