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
import com.dxh.Service.ScoreService;
import com.dxh.Service.UserService;
import com.dxh.common.utils.Page;
import com.dxh.po.BaseDict;
import com.dxh.po.Score;
import com.dxh.po.User;

@Controller
public class ScoreController {
	@Autowired
	private ScoreService scoreService;
	@Autowired
	private UserService userService;
	@Autowired
	private BaseDictService baseDictService;
	@Value("${Course.tea.type}")
	private String TEA_TYPE;
	@RequestMapping(value="/score/list.action")
	public String list(@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="10") Integer rows,
			String Student,String course_tea,Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("USER_SESSION");
		if(user.getChecked().equals("1"))
			course_tea=user.getStudent_id()+"";
		else if(user.getChecked().equals("0"))
			Student=user.getStudent_id()+"";
		Page<Score> scores =scoreService.findScoreList(page, rows, Student,course_tea);
		model.addAttribute("page",scores);
		List<BaseDict> teaType =baseDictService.findTimeDictByTypeCode(TEA_TYPE);
		model.addAttribute("teaType",teaType);
		model.addAttribute("Student",Student);
		model.addAttribute("course_tea",course_tea);
		if(user.getChecked().equals("0")){
			return "student_e";
		}else if (user.getChecked().equals("1"))
			return "teacher_e";
		else
			return "Administrators_e";
	}
	@RequestMapping("/score/getScoreById.action")
	@ResponseBody
	public Score getScoreById(Integer id){
		Score score = scoreService.getScoreById(id);
		System.out.println(score.getScore_id());
		return score;
	}
	@RequestMapping("/score/update.action")
	@ResponseBody
	public String CourseUpdate(Score score){
		int rows=scoreService.updateCourse(score);
		if(rows > 0){
			return "OK";
		}else{
			return "FALL";
		}
	}
}
