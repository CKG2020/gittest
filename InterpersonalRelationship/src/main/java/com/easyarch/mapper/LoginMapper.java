package com.easyarch.mapper;

import com.easyarch.entity.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
//一张表一个ｍａｐｐｅｒ　　　UserInfo表格

@Repository
@Mapper
public interface LoginMapper {

    @Select("select * from SSHpro.UserInfo where Sno= #{Sno}")
    MyUser loginUser(String Sno);

    int loginAdmin();



}
