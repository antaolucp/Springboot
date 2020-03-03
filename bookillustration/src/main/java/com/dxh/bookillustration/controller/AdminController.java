package com.dxh.bookillustration.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("/admin/login")
    public String adminlogin(){
        return "admin/login";
    }

    @RequestMapping("/admin/index")
    public String adminindex(){
        return "admin/index";
    }
}
