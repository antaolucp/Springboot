package com.dxh.Service.Impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxh.Service.StudentSerivce;
import com.dxh.common.utils.Page;
import com.dxh.dao.StudentDao;
import com.dxh.po.Student;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentSerivce {
	@Autowired
	private StudentDao studentDao;
	@Override
	public Page<Student> findStudentList(Integer page, Integer rows,
			String Student, String student_tie, String student_major,
			String student_grade) {
		// TODO 自动生成的方法存根
		Student student= new Student();
		if(StringUtils.isNoneBlank(Student)){
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(Student);
			if( !isNum.matches() )
	            student.setStudent_name(Student);
			else
				student.setStudent_id(Integer.parseInt(Student));
		}
		if(StringUtils.isNoneBlank(student_tie))
			student.setStudent_tie(student_tie);
		if(StringUtils.isNotBlank(student_major))
			student.setStudent_major(student_major);
		if(StringUtils.isNotBlank(student_grade))
			student.setStudent_grade(student_grade);
		student.setStart((page-1)*rows);
		student.setRows(rows);
		List<Student> students=studentDao.selectStudentList(student);
		Integer count =studentDao.selectStudentListCount(student);
		Page<Student> result =new Page<com.dxh.po.Student>();
		result.setPage(page);
		result.setRows(students);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}
	@Override
	public int createStudent(Student student) {
		return studentDao.createStudent(student);
	}
	@Override
	public Student getStudentById(Integer id) {
		Student student= studentDao.getStudentById(id);
		return student;
	}
	@Override
	public int updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}
	@Override
	public int deleteStudent(Integer id) {
		return studentDao.deleteStudent(id);
	}

}
