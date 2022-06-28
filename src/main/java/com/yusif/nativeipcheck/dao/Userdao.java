package com.yusif.nativeipcheck.dao;

import com.yusif.nativeipcheck.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface Userdao {
    @Select("SELECT * from user ")
    List<User> queryUserList();

//    User querUserbyid(int id);
//
//    int addUser(User user);
//
//    int deleteUser(int id);

}
