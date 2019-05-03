package com.wyl.tms.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wyl.tms.model.UserGoodsOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserGoodsOrderMapper extends BaseMapper<UserGoodsOrder> {
    @Select("SELECT * FROM user_goods_order WHERE user_id = #{userId} and order_status = #{status}")
    List<UserGoodsOrder> findPage(@Param("userId") Integer userId, @Param("status") Integer status, Page<UserGoodsOrder> page);
}