package com.wyl.tms.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wyl.tms.model.FilmInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FilmInfoMapper extends BaseMapper<FilmInfo> {
    @Select("SELECT * FROM film_info WHERE is_enabled = 1 AND film_status = #{status}")
    List<FilmInfo> findPage(@Param("status") Integer status, Page<FilmInfo> page);

    @Select("SELECT * FROM film_info WHERE is_enabled = 1 AND film_name like #{key}")
    List<FilmInfo> findPageByName(@Param("key") String key, Page<FilmInfo> page);
}