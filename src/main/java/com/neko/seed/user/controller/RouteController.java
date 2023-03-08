package com.neko.seed.user.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    @RequestMapping("/xc")
    public String xc() {
        return "/html/xc";
    }
    @RequestMapping("/hd")
    public String hd() {
        return "/html/hd";
    }
    @RequestMapping("/ly")
    public String ly() {
        return "/html/ly";
    }
    @RequestMapping("/dt")
    public String dt() {
        return "/html/dt";
    }
    @RequestMapping("/sc")
    public String sc() {
        return "/html/sc";
    }
    @RequestMapping("/zx")
    public String zx() {
        return "/html/zx";
    }
    @RequestMapping("/gr")
    public String gr() {
        return "/html/gr";
    }
    @RequestMapping("/login")
    public String login(){
        if (StpUtil.isLogin()){
            return "html/zx";
        }
        return "/login";
    }
    @RequestMapping("/reg")
    public String reg() {
        return "/reg";
    }
}
