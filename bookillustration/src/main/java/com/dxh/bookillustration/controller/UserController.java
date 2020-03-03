package com.dxh.bookillustration.controller;

import com.dxh.bookillustration.config.FileDownloadUtil;
import com.dxh.bookillustration.pojo.Atlas;
import com.dxh.bookillustration.pojo.Fans;
import com.dxh.bookillustration.pojo.KUser;
import com.dxh.bookillustration.pojo.Likes;
import com.dxh.bookillustration.service.UserService;
import com.dxh.bookillustration.service.UsersService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.cs.KOI8_U;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UsersService usersService;
    BCryptPasswordEncoder bc = new BCryptPasswordEncoder();

    @RequestMapping("/user/u/{user_id}")
    public String user(HttpSession session, @PathVariable("user_id") Integer user_id, Map map) {
        KUser user=(KUser) session.getAttribute("user");
        if (user!=null) {
            for (Fans fan : user.getFollows()) {

                if (fan.getUser_id() == user_id) {
                    System.out.println(fan.getUser_id());
                    map.put("followtext", "已关注");
                    break;
                }
            }
        }
        map.put("user", userService.finduserbyid(user_id));
        return "user/u";
    }

    @RequestMapping("/user/u/{user_id}/hua")
    public String hua(HttpSession session,@PathVariable("user_id") Integer user_id, Map map) {
        KUser user=(KUser) session.getAttribute("user");
        if (user!=null) {
            for (Fans fan : user.getFollows()) {

                if (fan.getUser_id() == user_id) {
                    System.out.println(fan.getUser_id());
                    map.put("followtext", "已关注");
                    break;
                }
            }
        }
        map.put("user", userService.finduserbyid(user_id));
        return "/user/hua";
    }

    @RequestMapping("/user/u/{user_id}/likes")
    public String like(HttpSession session,@PathVariable("user_id") Integer user_id, Map map) {
        KUser user=(KUser) session.getAttribute("user");

        if (user!=null) {
            for (Fans fan : user.getFollows()) {

                if (fan.getUser_id() == user_id) {
                    System.out.println(fan.getUser_id());
                    map.put("followtext", "已关注");
                    break;
                }
            }
        }
        map.put("user", userService.finduserbyid(user_id));
        map.put("likes", userService.findlikebyuserid(user_id));
        return "/user/like";
    }

    @RequestMapping("/user/u/{user_id}/follow")
    public String follow(HttpSession session,@PathVariable("user_id") Integer user_id, Map map) {
        KUser user=(KUser) session.getAttribute("user");
        KUser kuser=userService.finduserbyid(user_id);
        List<String> followstext=new ArrayList<String>();
        int i=0;
        if (user!=null) {

            for (Fans fan : user.getFollows()) {

                if (fan.getUser_id() == user_id) {
                    map.put("followtext", "已关注");
                    break;
                }
            }
            for(Fans fan  :kuser.getFollows()){
                for(Fans fanuser:user.getFollows()) {
                    if (fan.getUser_id() == fanuser.getUser_id()) {
                        followstext.add("已关注");
                        break;
                    }
                }
                if(followstext.size()==i){
                    followstext.add("关注");
                }
                i++;
            }
        }
        System.out.println(followstext);
        map.put("followstext",followstext);
        map.put("user", kuser);

        return "/user/follow";
    }

    @RequestMapping("/user/u/{user_id}/fans")
    public String fans(HttpSession session,@PathVariable("user_id") Integer user_id, Map map) {
        KUser user=(KUser) session.getAttribute("user");
        KUser kuser=userService.finduserbyid(user_id);
        List<String> followstext=new ArrayList<String>();
        int i=0;
        if (user!=null) {
            for (Fans fan : user.getFollows()) {

                if (fan.getUser_id() == user_id) {
                    System.out.println(fan.getUser_id());
                    map.put("followtext", "已关注");
                    break;
                }
            }
            for(Fans fan  :kuser.getFans()){
                for(Fans fanuser:user.getFollows()) {
                    if (fan.getFan_id() == fanuser.getUser_id()) {
                        followstext.add("已关注");
                        break;
                    }
                }
                if(followstext.size()==i){
                    followstext.add("关注");
                }
                i++;
            }
        }
        map.put("followstext",followstext);
        map.put("user", kuser);

        return "/user/fans";
    }

    @RequestMapping("/user/us/{user_id}/infosetting")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String infosetting(@PathVariable("user_id") Integer user_id, HttpSession session, String user_area, String user_name, String user_synopsis) {
        KUser user = (KUser) session.getAttribute("user");
        if (user.getUser_id() != user_id)
            return "redirect:/";
        if (user_name != null || user_synopsis != null || user_area != null) {
            System.out.println(user_area);
            user.setUser_id(user_id);
            user.setUser_name(user_name);
            user.setUser_area(user_area);
            user.setUser_synopsis(user_synopsis);
            session.setAttribute("user", user);
            userService.UpdataUser(user);
        }
        return "/users/infosetting";
    }

    @RequestMapping("/user/us/{user_id}/avatarsetting")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String avatarsetting(@PathVariable("user_id") Integer user_id, String area, HttpSession session) {
        System.out.println(area);
        return "/users/avatarsetting";
    }

    @ResponseBody
    @PostMapping("/user/us/avatarupload")
    public String avatarupload(@RequestParam("file") MultipartFile file,HttpSession session)throws IOException{
        KUser user=(KUser) session.getAttribute("user");
        if(file.isEmpty()){
            return "true";
        }
        System.out.println(file);
        String fileName = file.getOriginalFilename();
        String path="E:/web/asd/image.pzhan.com/pzhan/u/"+user.getUser_id();
        File dest = new File(path + "/" + fileName);
        user.setUser_icon("pzhan/u/"+user.getUser_id()+"/"+ fileName);
        userService.UpdataUser(user);
        session.setAttribute("user", user);
        FileDownloadUtil.UploadFile(file,dest,false);
        File tempFile = File.createTempFile("tempFile", "zip");
        return "true";
    }


    @RequestMapping("/user/us/{user_id}/passwordsetting")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String passwordsetting(@PathVariable("user_id") Integer user_id, HttpSession session) {
        KUser user = (KUser) session.getAttribute("user");
        if (user.getUser_id() != user_id)
            return "redirect:/";
        return "/users/passwordsetting";
    }

    @ResponseBody
    @PostMapping("/user/us/repassword")
    public String repassowrd(HttpSession session,String oldpassword, String password) {
        KUser user = (KUser) session.getAttribute("user");
        if (!bc.matches(oldpassword, user.getUser_password()))
            return "null";
        user.setUser_password(bc.encode(password));
        usersService.updateUserPassword(user);
        return "true";
    }
    @ResponseBody
    @PostMapping("/user/u/deletelike")
    public String deletelike(Likes likes){
        userService.Deletelike(likes);
        return "true";
    }
    @ResponseBody
    @PostMapping("/user/u/Insertlike")
    public String Insertlike(Likes likes){
        userService.Insertlike(likes);
        return "true";
    }
    @ResponseBody
    @PostMapping("/user/u/deletehua")
    public String deleteAtlas(Atlas atlas){

        return "true";
    }

    @ResponseBody
    @PostMapping("/user/u/followsdelete/{user_id}")
    public String followsdelete(@PathVariable("user_id") Integer user_id,  HttpSession session){
        KUser user=(KUser) session.getAttribute("user");
        Fans fans=new Fans();
        fans.setFan_id(user.getUser_id());
        fans.setUser_id(user_id);
        userService.followsdelete(fans);
        session.setAttribute("user",usersService.findUserbymail(user.getUser_mail()));
        return "true";
    }

    @ResponseBody
    @PostMapping("/user/u/followsInsert/{user_id}")
    public String followsInsert(@PathVariable("user_id") Integer user_id,  HttpSession session){
        KUser user=(KUser) session.getAttribute("user");
        Fans fans=new Fans();
        fans.setFan_id(user.getUser_id());
        fans.setUser_id(user_id);
        userService.followsInsert(fans);
        session.setAttribute("user",usersService.findUserbymail(user.getUser_mail()));
        return "true";
    }
}
