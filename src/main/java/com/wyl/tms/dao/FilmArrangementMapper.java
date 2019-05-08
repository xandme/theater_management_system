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


    @Select("SELECT * FROM film_arrangement a\n" +
            "LEFT JOIN film_hall_info h ON a.`film_hall_number` =  h.`film_hall_number`\n" +
            "WHERE h.`theater_id` = #{theaterId} and bh.`film_id` = #{filmId}")
    List<FilmArrangement> findPageByTheaterId(@Param("filmId") Integer filmId, @Param("theaterId") Integer theaterId, Page<FilmArrangement> page);


    @Select("SELECT DISTINCT DATE FROM film_arrangement a\n" +
            "LEFT JOIN film_hall_info h ON a.`film_hall_number`=h.`film_hall_number`\n" +
            "WHERE a.film_id = #{filmId} \n" +
            "AND h.`theater_id` = #{theaterId}")
    List<Date> selectDistinctDate(@Param("filmId") Integer filmId,@Param("theaterId") Integer theaterId);

    @Select("SELECT a.*,h.* FROM film_arrangement a \n" +
            "LEFT JOIN film_hall_info h ON a.`film_hall_number` = h.`film_hall_number` \n" +
            "WHERE a.film_id = #{filmId} AND a.DATE = '${date}' AND h.theater_id = #{theaterId} ORDER BY a.time")
    List<FilmHallVO> selectFilmHall(@Param("filmId") Integer filmId, @Param("theaterId") Integer theaterId, @Param("date") String date);
}