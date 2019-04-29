package com.wyl.tms.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wyl.tms.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}