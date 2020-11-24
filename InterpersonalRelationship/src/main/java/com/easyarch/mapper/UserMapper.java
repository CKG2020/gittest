package com.easyarch.mapper;

import com.easyarch.entity.MyUser;
import com.easyarch.entity.UserShow;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    @Select("select * from SSHpro.UserInfo where Sno= #{Sno}")
    public MyUser selectUser(@Param("sno")String  sno);

    @Select("select SSHpro.UserInfo.Sno,Sage,Scall,Sname,Sclass,Collage,Major,SSHpro.UserBoard.Scores from SSHpro.UserInfo,SSHpro.UserBoard where UserInfo.Sno=UserBoard.Sno")
    public UserShow findUserShow();

    @Select("  select\n" +
            "        UserInfo.Sno, Sname, Sage, Scall, Collage, Major, Sclass, Gender, Birth\n" +
            "        from SSHpro.UserInfo where UserInfo.Sno in (select SSHpro.pyq.Sno2 from SSHpro.pyq where Sno1=#{sno} and addStatus=1)")
    MyUser  myFriends(@Param("sno") String sno);

 @Select(" select\n" +
         "        UserInfo.Sno, Sname, Sage, Scall, Collage, Major, Sclass, Gender, Birth\n" +
         "        from SSHpro.UserInfo where UserInfo.Sno in (select SSHpro.pyq.Sno1 from SSHpro.pyq where Sno2=#{sno} and addStatus=0)")
    MyUser frinedsRequest(@Param("sno") String sno);

//    @Select("  select COUNT(*) from SSHpro.UserInfo")
//    int findallcount();

      @Select("  select Sno, Sname, Sage, Scall, Collage, Major, Sclass, Gender, Birth from SSHpro.UserInfo\n" +
              "        where Sno = #{sno}")
    MyUser findUserBySno(@Param("sno") String sno);


      //汇总查询
    //年龄
   @Select(" select COUNT(*) from SSHpro.UserInfo where Sage = #{age}")
      int findAgeCount(@Param("age") int age);
      //学院
   @Select(" select COUNT(*) from SSHpro.UserInfo where Collage like concat(concat(\"%\",#{collage}),\"%\")")
    int findCollageCount (@Param("collage") String collage);

  //班级
   @Select("  select COUNT(*) from SSHpro.UserInfo where Sclass like concat(concat(\"%\",#{sclass}),\"%\")")
   int  findClassCount(@Param("sclass")  String sclass);
   //名字
   @Select(" select COUNT(*) from SSHpro.UserInfo where Sname like  concat(concat(\"%\",#{sname}),\"%\")")
   int findNameCount(@Param("sname") String sname);
   //学号
   @Select("  select COUNT(*) from SSHpro.UserInfo where Sno like  concat(concat(\"%\",#{sno}),\"%\")")
   int findSnoCount(@Param("sno") String sno);

   //添加Myuser
    @Insert(" insert into SSHpro.UserInfo(Sno,Spwd) values (#{sno},#{spwd})")
    int addUser(@Param("sno") String sno,@Param("spwd") String spwd);
    //更新myuser 信息
    @Update("update SSHpro.UserInfo set\n" +
            "        Sname=#{sname},Sage=#{sage},\n" +
            "        Scall=#{scall},Collage=#{collage},\n" +
            "        Major=#{major},Sclass=#{sclass},\n" +
            "        Gender=#{gender},Birth=#{birth}\n" +
            "        where Sno=#{sno};")
    int updateUser(@Param("sname") String sname,@Param("sage") int sage,@Param("scall") String scall,
                   @Param("major")String major,@Param("sclass") String sclass,@Param("gender") int gender,
                   @Param("birth")String birth,@Param("sno") String sno);



    @Delete(" delete from SSHpro.UserInfo where Sno=#{sno};")
    int delUser(@Param("sno") String sno);

    //查找名字
    @Select(" select SSHpro.UserInfo.Sname from SSHpro.UserInfo where Sno=#{sno}")
    String searchSname(@Param("sno")String sno);
    //与上面一样
    @Select(" select SSHpro.UserInfo.Sname from SSHpro.UserInfo where Sno=#{sno}")
    String findUserNameBySno(@Param("sno")String sno);






































}
