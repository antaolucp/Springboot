package com.dxh.Service;

import com.dxh.common.utils.Page;
import com.dxh.po.Student;

public interface StudentSerivce {
	public Page<Student> findStudentList(Integer page, Integer rows,String Student, String student_tie, 
			String student_major,String student_grade);
	public int createStudent(Student student);
	public Student getStudentById(Integer id);
	public int updateStudent(Student student);
	public int deleteStudent(Integer id);
}
