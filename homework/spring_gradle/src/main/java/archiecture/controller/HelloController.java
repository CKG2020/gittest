package com.easy.archiecture.controller;

import com.easy.archiecture.dao.LogInfoMapper;
import com.easy.archiecture.entity.Demo;
import com.easy.archiecture.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

@RestController
public class HelloController {
@Autowired
private LoginService loginService;
        @RequestMapping(value = "/hello", method = RequestMethod.POST)
//    @GetMapping(value = "/hello")
    public String index(@RequestParam String name, String password) throws NoSuchAlgorithmException {
        System.out.println("xjjsaajksaaaslk");
        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] bytes = md.digest(password.getBytes());
        String mypasw = Base64.getEncoder().encodeToString(bytes);

        UUID id = UUID.randomUUID();
        String myid = id.toString();
        int i = loginService.insert(name, mypasw, myid);
        if (i!=0){
            return "success";
        }
        else{
            System.out.println("数据库操作有误");
            return "error";
        }
    }


    @PostMapping(value = "/hello2")
    public Demo index(Demo user) {
        System.out.println(user.getAge());
        return user;
    }

}