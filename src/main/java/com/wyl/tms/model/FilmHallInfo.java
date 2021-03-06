package com.wyl.tms.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@Data
public class FilmHallInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_hall_info.filmHallNumber
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    @TableId(value = "film_hall_number", type = IdType.AUTO)
    private Integer filmHallNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_hall_info.filmHallName
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private String filmHallName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_hall_info.seatQuantity
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Integer seatQuantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_hall_info.theaterId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Integer theaterId;
}