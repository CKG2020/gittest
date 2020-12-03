package com.easyarch.service;

import com.easyarch.entity.Tips;
import com.easyarch.mapper.PyqMapper;
import com.easyarch.mapper.UserBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PyqService {
     private int countRequest=0;

    @Autowired
    PyqMapper pyqMapper;
    @Autowired
    UserBoardMapper userBoardMapper;

    public int historyRequestCount(String sno) {
        countRequest=pyqMapper.countRequest(sno);
        System.out.println(countRequest);
        Tips tips = new Tips();
        tips.setSno(sno);
        tips.setCount(countRequest);
        userBoardMapper.setHistoryRequestCount(tips.getCount(),tips.getSno());
        return 0;
    }

}
