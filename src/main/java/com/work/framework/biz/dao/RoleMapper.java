package com.work.framework.biz.dao;

import com.work.framework.biz.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RoleMapper extends MyBaseMapper<Role> {

}