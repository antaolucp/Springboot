package com.dxh.bookillustration.controller;

import com.dxh.bookillustration.pojo.KUser;
import com.dxh.bookillustration.service.UsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class UsersController {
    @Autowired
    UsersService usersService;
    BCryptPasswordEncoder bc=new BCryptPasswordEncoder();
    @RequestMapping("/user/login")
    public String Login(){
        return "users/login";
    }
    @RequestMapping("/user/register")
    public String Register(){
        return "users/register";
    }

    @RequestMapping("/user/reset")
    public String Reset( HttpServletRequest request){
        return "users/reset";
    }
    @ResponseBody
    @PostMapping("/user/register/ok")
    public String  RegisterOK(KUser user){
        KUser users=usersService.findUserbymail(user.getUser_mail());
        if(users!=null){
            System.out.println(users);
            return "null";
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        user.setUser_time(df.format(new Date()));
        user.setUser_role("ROLE_USER");
        user.setUser_password(bc.encode(user.getUser_password()));
        user.setUser_icon("pzhan/u/avatar_mingren.png");
        usersService.InsetUser(user);
        return "true";
    }
    @RequestMapping("/user/reset/ok")
    public String ResetOK(String user_mail,String password){
        KUser user=new KUser();
        System.out.println(user_mail+""+password);
        user.setUser_mail(user_mail);
        user.setUser_password(bc.encode(password));
        System.out.println(user.getUser_password());
        usersService.updateUserPassword(user);
        return "redirect:/user";
    }

    @RequestMapping("/user/u")
    public String index(String page,Map map,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        if(page==null)
            page="";
        List<KUser> users =usersService.findUserall(page);
        PageInfo<KUser> pageInfo = new PageInfo<KUser>(users);
        map.put("page",page);
        map.put("pageInfo",pageInfo);
        map.put("users",users);
        return "users/index";
    }
    @RequestMapping("/user/writer")
    public String writer(Map map){
        map.put("users",usersService.findUserallcount());
        return "rank/writer";
    }

    @ResponseBody
    @PostMapping("/user/mail")
    public String mail(Map map, String user_mail, HttpServletRequest request, String register) throws MessagingException {
        KUser user=usersService.findUserbymail(user_mail);
        if(user == null && register.equals("no")){
            return "null";
        }
        Random random=new Random();
        int rannum= (int)(random.nextDouble()*(99999-10000 + 1))+ 10000;
        System.out.println(rannum);
//        usersService.sendEmail(user,rannum);

        return rannum+"";
    }
    @PostMapping("/user/us/{user_id}/infomail")
    public String findmail(@PathVariable("user_id") Integer user_id, String new_mail){
        KUser user=usersService.findUserbymail(new_mail);
        if(user !=null)
            return "redirect:/user/us/"+user_id+"/infosetting?error";
        user.setUser_mail(new_mail);
        user.setUser_id(user_id);
        return "redirect:/user/us/"+user_id+"/infosetting";
    }

}
