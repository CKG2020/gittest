package com.easyarch.controller;

import com.easyarch.entity.BoardMsg;
import com.easyarch.entity.FormValidate;
import com.easyarch.entity.MyUser;
import com.easyarch.mapper.UserMapper;
import com.easyarch.service.BoardMsgService;
import com.easyarch.service.PyqService;
import com.easyarch.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

//@RequestMapping("/stu")
@Controller
public class StuInfoController {

    @Autowired
    HttpServletRequest request;
    @Autowired
    BoardMsgService boardMsgService;
   @Autowired
    UserInfoService userInfoService;
   @Autowired
    PyqService pyqService;



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
        System.out.println("这是个什么问题？？？？？？？？？？？？");
//        boardMsgService.tipMsgCount()
        Object testuser = session.getAttribute("user");
        MyUser myUser=(MyUser)testuser;
        System.out.println(myUser.toString());
        int num = boardMsgService.tipRequestCount(((MyUser) session.getAttribute("user")).getSno());
        System.out.println(num);
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




    @RequestMapping(value = "moreInfo")
    public String moreInfo(){

        return "/stu/moreInfo";
    }

//聊天
    @RequestMapping(value = "chat")
    public String ChatRoom(){
        HttpSession session = request.getSession();
        MyUser user = (MyUser) session.getAttribute("user");
        System.out.println(user.getSname());
        return "test/chat";
    }


//问题
    @RequestMapping(value = "questions")
    public String Questions(){
        return "stu/questions";
    }



    @RequestMapping(value = "analyzing")
    public String Analyzing(){
//        userService.tipMsgCount()
        return "stu/analyzing";
    }

    @RequestMapping(value = "board")
    public String Board(){
        boardMsgService.setTimes(0);
        return "stu/board";
    }
    @RequestMapping(value = "friendList")
    public String FriendList(){

        return "stu/friendList";
    }

    @RequestMapping(value="findNameCount")
    @ResponseBody
    public int findNameCount(@RequestParam String Sname){
        return userInfoService.findNameCount(Sname);
    }

    @RequestMapping(value="findSnoCount")
    @ResponseBody
    public int findSnoCount(@RequestParam String Sno){
        return userInfoService.findSnoCount(Sno);
    }
//好友数量
    @RequestMapping(value="friendsCount")
    @ResponseBody
    public int friendsCount(){
        HttpSession session = request.getSession();
        return pyqService.findFriendsCount(((MyUser)session.getAttribute("user")).getSno());
    }
    @RequestMapping(value="FriendList/showFriends")
    @ResponseBody
    public List<MyUser> getFriends(){
        HttpSession session = request.getSession();
        System.out.println(((MyUser)session.getAttribute("user")).getSno());
        System.out.println(userInfoService.showFriends(((MyUser)session.getAttribute("user")).getSno()));
        return userInfoService.showFriends(((MyUser)session.getAttribute("user")).getSno());
    }



}
