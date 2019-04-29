package com.wyl.tms.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wyl.tms.model.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsInfoMapper extends BaseMapper<GoodsInfo> {
    @Select("SELECT * FROM goods_info WHERE goods_type = #{type} AND theater_id = #{theaterId}")
    List<GoodsInfo> findPage(@Param("theaterId") Integer theaterId, @Param("type") Integer type, Page<GoodsInfo> page);
}