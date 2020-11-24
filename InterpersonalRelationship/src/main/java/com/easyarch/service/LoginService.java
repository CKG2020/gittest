package com.easyarch.service;

import com.easyarch.entity.MyUser;
import com.easyarch.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;

    public Object loginUser( String Sno,String Spwd){
//        return loginMapper.loginUser(Sno);

      MyUser myUser =loginMapper.loginUser(Sno);
        if (myUser !=null){
            if(Spwd.equals(myUser.getSpwd())){
                return myUser;
            }else{
                return 1;
            }
        }else{
            return 0;
        }
    }




}
