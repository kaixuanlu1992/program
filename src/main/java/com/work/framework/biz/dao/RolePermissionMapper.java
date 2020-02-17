package com.work.framework.biz.dao;

import com.work.framework.biz.model.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RolePermissionMapper extends MyBaseMapper<RolePermission> {

}