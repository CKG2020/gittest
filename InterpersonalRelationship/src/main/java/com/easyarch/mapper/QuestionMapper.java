package com.easyarch.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface QuestionMapper {
    @Select(" select SSHpro.Questions.PageUrl from SSHpro.Questions")
   public String selectQuestion();

}
