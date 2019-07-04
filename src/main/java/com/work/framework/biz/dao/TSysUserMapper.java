package com.work.framework.biz.dao;

import com.work.framework.biz.model.TSysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TSysUserMapper extends MyBaseMapper<TSysUser> {

}