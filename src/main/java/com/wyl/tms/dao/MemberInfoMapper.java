package com.wyl.tms.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wyl.tms.model.MemberInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberInfoMapper extends BaseMapper<MemberInfo> {
}