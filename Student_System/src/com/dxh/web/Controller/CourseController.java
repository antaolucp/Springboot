package com.dxh.web.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dxh.Service.BaseDictService;
import com.dxh.Service.CourseService;
import com.dxh.Service.UserService;
import com.dxh.common.utils.Page;
import com.dxh.po.BaseDict;
import com.dxh.po.Course;
import com.dxh.po.User;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseSerivce;
	@Autowired
	private UserService userService;
	@Autowired
	private BaseDictService baseDictService;
	@Value("${Course.time1.type}")
	private String TIME1_TYPE;
	@Value("${Course.time2.type}")
	private String TIME2_TYPE;
	@Value("${Course.tea.type}")
	private String TEA_TYPE;
	@RequestMapping(value="/course/list.action")
	public String list(@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="5") Integer rows,
			String Course,String course_tea,String course_time_1,String course_time_2,Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("USER_SESSION");
		String status= request.getParameter("status");
		Page<Course> courses=null;
		if(user.getChecked().equals("1")){
			BaseDict courseDict=baseDictService.findTimeDictById(user.getStudent_id());
			courses =courseSerivce.findCourseList(page, rows,Course,courseDict.getDict_item_name(),course_time_1,course_time_2,null,status);
		}else
			courses =courseSerivce.findCourseList(page, rows,Course,course_tea,course_time_1,course_time_2,user.getStudent_id(),status);
		model.addAttribute("page",courses);
		List<BaseDict> time1type =baseDictService.findTimeDictByTypeCode(TIME1_TYPE);
		List<BaseDict> time2type =baseDictService.findTimeDictByTypeCode(TIME2_TYPE);
		List<BaseDict> teatype =baseDictService.findTimeDictByTypeCode(TEA_TYPE);
		model.addAttribute("time1type",time1type);
		model.addAttribute("time2type",time2type);
		model.addAttribute("teatype",teatype);
		model.addAttribute("Course",Course);
		model.addAttribute("course_tea",course_tea);
		model.addAttribute("course_time_1",course_time_1);
		model.addAttribute("course_time_2",course_time_2);
		if(user.getChecked().equals("0")){
			return "student_c";
		}else if (user.getChecked().equals("1"))
			return "teacher_c";
		else
			return "Administrators_c";
	}
	@RequestMapping("/course/createStudentCourse.action")
	@ResponseBody
	public String CreateStudentCourse(Integer course_id,HttpServletRequest request){
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("USER_SESSION");
		int rows=courseSerivce.CreateStudentCourse(course_id, user.getStudent_id());
		if(rows > 0){
			return "OK";
		}else{
			return "FALL";
		}
	}
	@RequestMapping("/course/create.action")
	@ResponseBody
	public String courseCreate(Course course){
		int rows=courseSerivce.createCourse(course);
		if(rows > 0){
			return "OK";
		}else{
			return "FALL";
		}
	}
	@RequestMapping("/course/delete.action")
	@ResponseBody
	public String courseDelete(Integer id){
		int rows=courseSerivce.deleteCourse(id);
		if(rows > 0){
			return "OK";
		}else{
			return "FALL";
		}
	}
	@RequestMapping("/course/update.action")
	@ResponseBody
	public String CourseUpdate(Course course){
		int rows=courseSerivce.updateCourse(course);
		if(rows > 0){
			return "OK";
		}else{
			return "FALL";
		}
	}
	@RequestMapping("/course/getCourseById.action")
	@ResponseBody
	public Course getCourseById(Integer id){
		Course course = courseSerivce.getCourseById(id);
		return course;
	}
}
