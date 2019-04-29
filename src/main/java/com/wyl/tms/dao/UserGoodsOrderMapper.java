package com.wyl.tms.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wyl.tms.model.GoodsInfo;
import com.wyl.tms.model.UserGoodsOrder;
import com.wyl.tms.model.UserGoodsOrderExample;

import java.util.List;

import com.wyl.tms.vo.GoodsOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserGoodsOrderMapper extends BaseMapper<UserGoodsOrder> {
    @Select("SELECT * FROM user_goods_order WHERE user_id = #{userId}")
    List<UserGoodsOrder> findPage(@Param("userId") Integer userId, Page<UserGoodsOrder> page);
}