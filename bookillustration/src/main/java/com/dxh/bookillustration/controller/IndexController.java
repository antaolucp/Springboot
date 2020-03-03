package com.dxh.bookillustration.controller;

import com.dxh.bookillustration.service.IndexService;
import com.dxh.bookillustration.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    IndexService indexService;
    @Autowired
    UsersService usersService;

    @RequestMapping("/user")
    public String index(Map map, HttpSession session){
        String mail = getUsername() ;
        System.out.println(mail);
        if(mail != null)
            session.setAttribute("user",usersService.findUserbymail(mail));
        map.put("labelall",indexService.findlabelall());
        map.put("Atlasshot",indexService.findAtlasallhot());
        map.put("Atlastime",indexService.findAtlasalltime());
        map.put("books",indexService.findBookallgood());
        map.put("users",indexService.findUserallgood());
        map.put("Atlashotandtime",indexService.findAtlasallhottime());
        return "index";
    }
    /**
     * 获得当前用户权限
     */
    private String getUsername() {
        // 从SecurityContex中获得Authentication对象代表当前用户的信息
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("username = " + username);
        return username;
    }

}
