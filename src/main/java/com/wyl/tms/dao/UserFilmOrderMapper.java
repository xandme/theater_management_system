package com.wyl.tms.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wyl.tms.dao.provider.VOrderDetailProvider;
import com.wyl.tms.model.UserFilmOrder;
import com.wyl.tms.model.UserGoodsOrder;
import com.wyl.tms.model.VOrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface UserFilmOrderMapper extends BaseMapper<UserFilmOrder> {

    @Select("SELECT * FROM user_film_order WHERE user_id = #{userId} AND order_status = #{status}")
    List<UserFilmOrder> findPage(@Param("userId") Integer userId, @Param("status") Integer status, Page<UserGoodsOrder> page);

    @SelectProvider(type = VOrderDetailProvider.class, method = "findDetailPage")
    List<VOrderDetail> findDetailPage(@Param("status") Integer status, @Param("userId") Integer userId, Page<VOrderDetail> page);
}