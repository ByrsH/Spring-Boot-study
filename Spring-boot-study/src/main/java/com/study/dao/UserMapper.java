package com.study.dao;

import com.study.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */
@Mapper
public interface UserMapper {
    List<User> findAll();
}
