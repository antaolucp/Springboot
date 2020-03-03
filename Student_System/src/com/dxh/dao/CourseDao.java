package com.dxh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dxh.po.Course;
import com.dxh.po.StudentCourse;

public interface CourseDao {
	public List<Course> selectCourseList(Course course);
	public Integer selectCourseListCount(Course course);
	public int CreateStudentCourse(StudentCourse studentcourse);
	public List<Course> selectCoursestuList(@Param("student_id") Integer student_id, @Param("start") Integer start,@Param("rows") Integer rows,
			 @Param("course_id") Integer course_id, @Param("course_name") String course_name , @Param("course_time_1") String course_time_1,
			 @Param("course_time_2") String course_time_2,@Param("course_tea") String course_tea,@Param("status") String status);
	public int createCourse(Course course);
	public Course getCourseById(Integer id);
	public int updateCourse(Course course);
	public int deleteCourse(Integer id);
	public int deleteCourseStu(Integer id);
}
