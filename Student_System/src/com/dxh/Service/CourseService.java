package com.dxh.Service;

import com.dxh.common.utils.Page;
import com.dxh.po.Course;

public interface CourseService {
	public Page<Course> findCourseList(Integer page, Integer rows,String course,String course_tea,
							String course_time_1,String course_time_2,Integer student_id,String status);
	public int CreateStudentCourse(Integer course_id,Integer student_id);
	public int createCourse(Course course);
	public Course getCourseById(Integer id);
	public int updateCourse(Course course);
	public int deleteCourse(Integer id);
}
