package com.wyl.tms.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wyl.tms.model.FilmArrangement;
import com.wyl.tms.vo.FilmHallVO;
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

    @Select("SELECT a.*,h.* FROM film_arrangement a \n" +
            "LEFT JOIN film_hall_info h ON a.`film_hall_number` = h.`film_hall_number` \n" +
            "WHERE film_id = #{filmId} AND DATE = '${date}' ORDER BY a.time")
    List<FilmHallVO> selectFilmHall(@Param("filmId") Integer filmId, @Param("date") String date);
}