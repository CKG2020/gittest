package com.easyarch.controller;

import com.easyarch.entity.BoardMsg;
import com.easyarch.entity.FormValidate;
import com.easyarch.entity.MyUser;
import com.easyarch.mapper.UserMapper;
import com.easyarch.service.BoardMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//@RequestMapping("/stu")
@Controller
public class StuInfoController {

    @Autowired
    HttpServletRequest request;
    @Autowired
    BoardMsgService boardMsgService;
//    @Autowired
//    UserMapper userMapper;



    @RequestMapping(value = "moreInfo")
    public String MoreInfo(){

        return "/stu/moreInfo";
    }


    @RequestMapping(value="newMsgCount")
    @ResponseBody
    public int newMsgCount(){
        HttpSession session = request.getSession();
        return boardMsgService.tipMsgCount(((MyUser)session.getAttribute("user")).getSno());
    }


    @RequestMapping(value="newRequestCount")
    @ResponseBody
    public int newRequestCount(){
        HttpSession session = request.getSession();
        return boardMsgService.tipRequestCount(((MyUser)session.getAttribute("user")).getSno());
    }


    @RequestMapping(value = "update")
    @ResponseBody
    public String updateInfo(@RequestBody FormValidate formValidate){
//        userService.updateUser(formValidate);
        boardMsgService.updateUser(formValidate);
        System.out.println(formValidate.toString());
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.setAttribute("user",boardMsgService.findUserBySno(formValidate.getSno()));
        return "ok";
    }





    @RequestMapping(value = "chat")
    public String ChatRoom(){
        HttpSession session = request.getSession();
        MyUser user = (MyUser) session.getAttribute("user");
        System.out.println(user.getSname());
        return "test/chat";
    }

    @RequestMapping(value = "analyzing")
    public String Analyzing(){
//        userService.tipMsgCount()
        return "stu/Analyzing";
    }

    @RequestMapping(value = "board")
    public String Board(){
        boardMsgService.setTimes(0);
        return "stu/Board";
    }
    @RequestMapping(value = "friendList")
    public String FriendList(){

        return "stu/FriendList";
    }



}
