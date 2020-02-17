package com.work.framework.biz.dao;

import com.work.framework.biz.model.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper extends MyBaseMapper<User> {

}