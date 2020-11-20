package com.easy.archiecture.service;

import com.easy.archiecture.dao.LogInfoMapper;
import com.easy.archiecture.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LogInfoMapper logInfoMapper;

    public int insert(String name, String password, String id){
          return  logInfoMapper.insertUser(name, password, id);

    }
}
