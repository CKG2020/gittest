package com.easyArch.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionMapper {
    @Select( {"select SSHpro.Questions.PageUrl from SSHpro.Questions")
    public  void  loadAnswers();
}
//<select id="loadAnswers" resultType="java.lang.String" >
//        select SSHpro.Questions.PageUrl from SSHpro.Questions
//</select>