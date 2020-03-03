package com.dxh.Service.Impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxh.Service.CourseService;
import com.dxh.common.utils.Page;
import com.dxh.dao.CourseDao;
import com.dxh.po.Course;
import com.dxh.po.StudentCourse;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;
	@Override
	public Page<Course> findCourseList(Integer page, Integer rows,
			String Course,String course_tea, String course_time_1,String course_time_2,Integer student_id,String status) {
		Course course =new Course();
		List<Course> courses=null;
		course.setStart((page-1)*rows);
		course.setRows(rows);
		if(StringUtils.isNoneBlank(Course)){
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(Course);
			if( !isNum.matches() )
				course.setCourse_name(Course);
			else
				course.setCourse_id(Integer.parseInt(Course));
		}
		if(StringUtils.isNoneBlank(course_tea))
			course.setCourse_tea(course_tea);
		if(StringUtils.isNoneBlank(course_time_1))
			course.setCourse_time_1(course_time_1);
		if(StringUtils.isNoneBlank(course_time_2))
			course.setCourse_time_2(course_time_2);
		if(student_id==null){
			courses=courseDao.selectCourseList(course);
		}else if(status== null){
			status="false";
			courses=courseDao.selectCoursestuList(student_id,course.getStart(),course.getRows(),course.getCourse_id(),
					course.getCourse_name(),course.getCourse_time_1(),course.getCourse_time_2(),course.getCourse_tea(),status);
		}else{
			courses=courseDao.selectCoursestuList(student_id,course.getStart(),course.getRows(),course.getCourse_id(),
			course.getCourse_name(),course.getCourse_time_1(),course.getCourse_time_2(),course.getCourse_tea(),status);
		}
		
		Integer count =courseDao.selectCourseListCount(course);
		Page<Course> result =new Page<com.dxh.po.Course>();
		result.setPage(page);
		result.setRows(courses);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}
	@Override
	public int CreateStudentCourse(Integer course_id,
			Integer student_id) {
		// TODO 自动生成的方法存根
		StudentCourse studentcourse=new StudentCourse();
		studentcourse.setCourse_id(course_id);
		studentcourse.setStudent_id(student_id);
		return courseDao.CreateStudentCourse(studentcourse);
	}
	@Override
	public int createCourse(Course course) {
		// TODO 自动生成的方法存根
		return courseDao.createCourse(course);
	}
	@Override
	public Course getCourseById(Integer id) {
		Course course= courseDao.getCourseById(id);
		return course;
	}
	@Override
	public int updateCourse(Course course) {
		// TODO 自动生成的方法存根
		return courseDao.updateCourse(course);
	}
	@Override
	public int deleteCourse(Integer id) {
		System.out.println(id);
		courseDao.deleteCourseStu(id);
		// TODO 自动生成的方法存根
		return courseDao.deleteCourse(id);
	}

}
