package com.easyarch.service;

import com.easyarch.entity.FormValidate;
import com.easyarch.entity.MyUser;
import com.easyarch.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    //    @Autowired
//    private LoginMapper loginMapper;
    @Autowired
    UserMapper userMapper;
 //登录
    public Object loginUser(String Sno, String Spwd) {
//        return loginMapper.loginUser(Sno);

        MyUser myUser = userMapper.loginUser(Sno);
        if (myUser != null) {
            if (Spwd.equals(myUser.getSpwd())) {
                return myUser;
            } else {
                return 1;
            }
        } else {
            return 0;
        }

    }

//按学号查找　　确定是否重复
    public MyUser findUserBySno(String Sno){
     return userMapper.findUserBySno(Sno);
    }

    //注册添加新用户
    public int addUser(String Sno,String Spwd){
        int a= userMapper.addUser(Sno, Spwd);
        if (a!=0){
            return 1;
        }
        else
            return 0;
    }

    //完善信息


    public int   updateUser(FormValidate  formValidate){
        return   userMapper.updateUser(formValidate.getSname(),formValidate.getAge(),formValidate.getScall(),
             formValidate.getCollage(),formValidate.getMajor(),formValidate.getSclass(),formValidate.getGender(),formValidate.getBirth(),formValidate.getSno());
    }
    //    update SSHpro.UserInfo set\n" +
//            "        Sname=#{sname},Sage=#{sage},\n" +
//            "        Scall=#{scall},Collage=#{collage},\n" +
//            "        Major=#{major},Sclass=#{sclass},\n" +
//            "        Gender=#{gender},Birth=#{birth}\n" +
//            "        where Sno=#{sno};")

//    int updateUser(@Param("sname") String sname, @Param("sage") int sage, @Param("scall") String scall,
//                   @Param("major")String major, @Param("sclass") String sclass, @Param("gender") int gender,
//                   @Param("birth")String birth, @Param("sno") String sno);


//    private String sno;
//    private String name;
//    private int age;
//    private String call;
//    private String collage;
//    private String major;
//    private String sclass;
//    private int gender;
//    private String  birth;

}
