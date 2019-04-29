package com.wyl.tms.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wyl.tms.model.TheaterInfo;
import com.wyl.tms.model.TheaterInfoExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TheaterInfoMapper extends BaseMapper<TheaterInfo> {
    @Select("SELECT * FROM theater_info")
    List<TheaterInfo> findPage(Page<TheaterInfo> page);
}