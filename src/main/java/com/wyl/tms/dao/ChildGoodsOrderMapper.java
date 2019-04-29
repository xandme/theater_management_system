package com.wyl.tms.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wyl.tms.model.ChildGoodsOrder;
import com.wyl.tms.model.ChildGoodsOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChildGoodsOrderMapper extends BaseMapper<ChildGoodsOrder> {
}