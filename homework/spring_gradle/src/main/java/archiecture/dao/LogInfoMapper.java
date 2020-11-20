package com.easy.archiecture.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Repository
@Mapper
public interface LogInfoMapper {
    @Insert("INSERT INTO User  (name,password,id) VALUES (#{name},#{password},#{id})")
    public int insertUser(@Param("name") String name, @Param("password") String password, @Param("id") String id);
}
