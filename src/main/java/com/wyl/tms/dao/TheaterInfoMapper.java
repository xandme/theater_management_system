package com.wyl.tms.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wyl.tms.model.TheaterInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TheaterInfoMapper extends BaseMapper<TheaterInfo> {
    @Select("SELECT * FROM theater_info")
    List<TheaterInfo> findPage(Page<TheaterInfo> page);
}