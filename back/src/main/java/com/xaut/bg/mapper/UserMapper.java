package com.xaut.bg.mapper;

import com.xaut.bg.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from m_user")
    public List<User> find();



}
