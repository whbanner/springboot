package com.example.domain;

import org.apache.ibatis.annotations.*;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    @Select("SELECT classtime FROM Organization where oid=#{oid}")
    Integer findzclasstime(int oid);

    @Select("SELECT tid,tname from Teacher where oid=#{oid}")
    List<AllBean> findtidtname(int oid);

    @Select("select classtime from classTime where tid=#{tid}")
    Integer[] findclasstime(int tid);

    @Select("SELECT * FROM  classTime where oid=#{oid}")
    List<AllBean> findallIdClasstime(int oid);

    @Select("SELECT aname FROM Artist where aid=#{aid}")
    String findaname(int aid);

    @Select("SELECT sname FROM Student where sid=#{sid}")
    String findsname(int sid);

    @Select("SELECT * FROM Upload where uid=#{uid}")
    AllBean findUallMessage(int uid);

    @Select("SELECT * FROM feed WHERE fid=#{fid}")
    AllBean findFallMessage(int fid);

    @Select("SELECT * FROM Subscribe WHERE oid=#{oid}")
    List<AllBean> findSubscribe(int oid);

    @Insert("INSERT INTO Subscribe VALUES(#{aid},#{allstudent},#{sutime},#{oid},#{suid},#{sudate},'0',#{spectrum},#{song})")
    int insertSubscribe(@Param("aid") Integer aid, @Param("allstudent") String sutime, @Param("oid") Integer oid,
                        @Param("suid")Integer suid,@Param("sudate")String sudate,
                        @Param("spectrum")String spectrum,@Param("song")String song);

    @Insert("INSERT INTO Subscribe VALUES(#{aid},#{allstudent},#{sutime},#{oid},#{suid},#{sudate},'0',#{spectrum},#{song})")
    int insertSub(AllBean allBean);

    @Select("SELECT username,password,one FROM Organization where oid=#{oid}")
    AllBean findManager(int oid);

    @Update("UPDATE Organization set username=#{username},password=#{password} where oid=#{oid}")
    void update(String username,String password,int oid);


//    @Select("SELECT * FROM test1 WHERE name =#{name}")
//    AllBean findByName(@Param("name") String name);
//
//
//
//    @Results({
//            @Result(property = "name", column = "name"),
//            @Result(property = "age", column = "age")
//    })
//    @Select("SELECT name, age FROM test1")
//    List<AllBean> findAll();
//
//
//    @Insert("INSERT INTO test1(name, age) VALUES(#{name}, #{age})")
//    int insert(@Param("name") String name, @Param("age") Integer age);
//
//    @Update("UPDATE test1 SET age=#{age} WHERE name=#{name}")
//    void update(AllBean allBean);
//
//    @Delete("DELETE FROM test1 WHERE id =#{id}")
//    void delete(Long id);
//
//    @Insert("INSERT INTO test1(name, age) VALUES(#{name}, #{age})")
//    int insertByUser(AllBean allBean);
//
//    @Insert("INSERT INTO test1(name, age) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
//    int insertByMap(Map<String, Object> map);

}