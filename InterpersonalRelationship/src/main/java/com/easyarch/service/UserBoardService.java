package com.easyarch.service;

import com.easyarch.mapper.UserBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserBoardService {
    @Autowired
    private UserBoardMapper userBoardMapper;

    public int tipMsgCount(String sno){
        int count1 = userBoardMapper.boardMsgCount(sno);


    }
}
