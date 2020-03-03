package com.dxh.web.Controller;

import java.util.Calendar;
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
import com.dxh.Service.StudentSerivce;
import com.dxh.Service.UserService;
import com.dxh.common.utils.Page;
import com.dxh.po.BaseDict;
import com.dxh.po.Student;
import com.dxh.po.User;

@Controller
public class StudentController {
	@Autowired
	private StudentSerivce studentService;
	@Autowired
	private UserService userService;
	@Autowired
	private BaseDictService baseDictService;
	@Value("${Student.tie.type}")
	private String TIE_TYPE;
	@Value("${Student.major.type}")
	private String MAJOR_TYPE;
	@Value("${Student.grade.type}")
	private String GRADE_TYPE;
	@RequestMapping(value="/student/list.action")
	public String list(@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="10") Integer rows,
				String Student,String student_tie,String student_major,String student_grade,Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("USER_SESSION");
		Page<Student> students =studentService.findStudentList(page, rows, Student,student_tie, student_major, student_grade);
		model.addAttribute("page",students);
		List<BaseDict> tieType =baseDictService.findBaseDictByTypeCode(TIE_TYPE);
		List<BaseDict> majorType =baseDictService.findBaseDictByTypeCode(MAJOR_TYPE);
		List<BaseDict> gradeType =baseDictService.findBaseDictByTypeCode(GRADE_TYPE);
		model.addAttribute("tieType",tieType);
		model.addAttribute("majorType",majorType);
		model.addAttribute("gradeType",gradeType);
		model.addAttribute("Student",Student);
		model.addAttribute("student_tie",student_tie);
		model.addAttribute("student_major",student_major);
		model.addAttribute("student_grade",student_grade);
		if(user.getChecked().equals("0")){
			Student student = studentService.getStudentById(user.getStudent_id());
			model.addAttribute(student);
			return "student_s";
		}else if (user.getChecked().equals("1"))
			return "teacher_s";
		else
			return "Administrators_s";
	}
	@RequestMapping("/student/create.action")
	@ResponseBody
	public String studentCreate(Student student,HttpSession session){
		User user = new User();
		int y,m,d;    
		Calendar cal=Calendar.getInstance();    
		y=cal.get(Calendar.YEAR);    
		m=cal.get(Calendar.MONTH)+1;    
		d=cal.get(Calendar.DATE);    
		int rows=studentService.createStudent(student);
		user.setUsercode(y+""+m+""+d+""+student.getStudent_id());
		user.setStudent_id(student.getStudent_id());
		user.setUsername(student.getStudent_name());
		user.setPassword(student.getStudent_birth().replace("-", ""));
		user.setChecked("0");
		userService.CreateUser(user);
		if(rows > 0){
			return "OK";
		}else{
			return "FALL";
		}
	}
	
	@RequestMapping("/student/getStudentById.action")
	@ResponseBody
	public Student getStudentById(Integer id){
		Student student = studentService.getStudentById(id);
		return student;
	}
	
	@RequestMapping("/student/update.action")
	@ResponseBody
	public String StudentUpdate(Student student){
		int rows=studentService.updateStudent(student);
		if(rows > 0){
			return "OK";
		}else{
			return "FALL";
		}
	}
	@RequestMapping("/student/delete.action")
	@ResponseBody
	public String StudentDelete(Integer id){
		int rows=studentService.deleteStudent(id);
		userService.DeleteUser(id);
		if(rows > 0){
			return "OK";
		}else{
			return "FALL";
		}
		
	}
}
