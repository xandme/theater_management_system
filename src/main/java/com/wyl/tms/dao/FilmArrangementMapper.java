package com.wyl.tms.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wyl.tms.model.FilmArrangement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FilmArrangementMapper extends BaseMapper<FilmArrangement> {
    @Select("SELECT * FROM film_arrangement WHERE theater_id = #{theaterId} AND film_id = #{filmId}")
    List<FilmArrangement> findPage(@Param("theaterId") Integer theaterId, @Param("filmId") Integer filmId, Page<FilmArrangement> page);
}