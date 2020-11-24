package com.easyarch.controller;

import com.easyarch.entity.MyUser;
import com.easyarch.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    LoginService loginService;

    @RequestMapping("/loginAdmin")
    public String loginAdmin(){
        return "first/loginAdmin";
    }

    @RequestMapping("/login")
    public String login(){
        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null){
            session.removeAttribute("user");
            session.removeAttribute("userBoard");
        }
        return "first/login";
    }
    //用户登录
    @RequestMapping(value = "checkUser" ,method = RequestMethod.POST)
    @ResponseBody
    public Object checkUser(@RequestParam String Sno, String Spwd){
        MyUser myUser;
        Object obj =loginService.loginUser(Sno,Spwd);
        if (obj.equals(1)||obj.equals(0)){
            return obj.toString();
        }
        HttpSession session = request.getSession();
        myUser =(MyUser)obj;
        session.setAttribute("user", myUser);
        return myUser;
    }

    //    跳转后再把user查出来
    @RequestMapping("search")
    @ResponseBody
    public Object search(){
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("user"));
        return session.getAttribute("user");
    }






}
