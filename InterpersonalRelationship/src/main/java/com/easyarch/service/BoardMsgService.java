package com.easyarch.service;

import com.easyarch.entity.FormValidate;
import com.easyarch.entity.MyUser;
import com.easyarch.entity.UserShow;
import com.easyarch.mapper.BoardMsgMapper;
import com.easyarch.mapper.PyqMapper;
import com.easyarch.mapper.UserBoardMapper;
import com.easyarch.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardMsgService {

    @Autowired
    BoardMsgMapper boardMsgMapper;


    @Autowired
    UserBoardMapper userBoardMapper;

    @Autowired
    PyqMapper pyqMapper;


    @Autowired
    UserMapper userMapper;




      List<UserShow> userList;

    private int countMsg = 0;
    private int countRequest = 0;
    private int times = 0;

    public int countBoardMsg(String sno) {
        return boardMsgMapper.boardMsgCount(sno);
    }

    public int tipMsgCount(String sno) {
        int count1 = boardMsgMapper.boardMsgCount(sno);
        countMsg = userBoardMapper.historyMsgCount(sno);

        if (count1 > countMsg) {
            return count1 - countMsg;
        } else {
            return 0;
        }
    }


    public int tipRequestCount(String sno) {

        int m = pyqMapper.countRequest(sno);
        countRequest = userBoardMapper.historyRequestCount(sno);
        if (m > countRequest) {
            return m - countRequest;
        } else {
            return 0;
        }
    }

    public boolean updateUser(FormValidate form) {
        MyUser user = new MyUser();
        user.setSname(form.getSname());
        user.setBirth(form.getBirth());
        user.setCollage(form.getCollage());
        user.setGender(form.getGender());
        user.setSno(form.getSno());
        user.setSage(form.getAge());
        user.setMajor(form.getMajor());
        user.setSclass(form.getSclass());
        user.setScall(form.getScall());

        int i = userMapper.updateUser(user.getSname(), user.getSage(), user.getScall(),user.getCollage(),user.getMajor(), user.getSclass(), user.getGender(), user.getBirth(), user.getSno());

        if (i != 0) {
            return true;
        } else {
            return false;
        }
    }

    public MyUser findUserBySno(String sno){
         return  userMapper.findUserBySno(sno);
    }

    public void setTimes(int times) {
        this.times = times;
    }




}
