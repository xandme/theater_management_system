package com.wyl.tms.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wyl.tms.model.FilmArrangement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface FilmArrangementMapper extends BaseMapper<FilmArrangement> {
    @Select("SELECT * FROM film_arrangement WHERE film_id = #{filmId}")
    List<FilmArrangement> findPage(@Param("filmId") Integer filmId, Page<FilmArrangement> page);

    @Select("SELECT DISTINCT date FROM film_arrangement WHERE film_id = #{filmId}")
    List<Date> selectDistinctDate(@Param("filmId") Integer filmId);
}