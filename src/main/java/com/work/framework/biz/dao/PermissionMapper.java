package com.work.framework.biz.dao;

import com.work.framework.biz.model.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PermissionMapper extends MyBaseMapper<Permission> {

}