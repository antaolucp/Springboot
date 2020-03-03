package com.dxh.web.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dxh.Service.UserService;
import com.dxh.po.User;
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/login.action", method=RequestMethod.POST)
	public String login(String usercode,String password,String checked,Model model,HttpSession session){
		System.out.println(usercode);
		System.out.println(password);
		if(usercode=="" || password==""){
			model.addAttribute("msg" ,"账号或密码不能为空");
			return "login";
		}
		User user =userService.findUser(usercode, password, checked);
		
		if(user!=null){
			if(checked.equals("0")){
				System.out.println(checked);
				session.setAttribute("USER_SESSION", user);
				return "redirect:/student/list.action";
			}else if(checked.equals("1")){
				session.setAttribute("USER_SESSION", user);
				return "redirect:/student/list.action";
			}else if(checked.equals("2")){
				session.setAttribute("USER_SESSION", user);
				return "redirect:/student/list.action"; 
			}
		}
		model.addAttribute("msg" ,"账号或密码输入错误，请重新输入！");
		return "login";
	}
	@RequestMapping(value="/logout.action")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:login.action";
	}
	@RequestMapping(value ="/login.action",method=RequestMethod.GET)
	public String toLogin(){
		return "login";
	}
	@RequestMapping("/user/getUserById.action")
	@ResponseBody
	public User getUserById(Integer id){
		User user = userService.getUserById(id);
		return user;
	}
	@RequestMapping("/user/update.action")
	@ResponseBody
	public String userUpdate(User user,String password1,String password2){
		if(password1.equals(password2)){}
		else return "FAIL";
		int rows = userService.updateUser(user,password1);
		if(rows>0)
			return "OK";
		else
			return "FAIL";
	}
}
