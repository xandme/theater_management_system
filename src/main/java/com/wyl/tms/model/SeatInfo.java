package com.wyl.tms.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@Data
public class SeatInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seat_info.seatId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    @TableId(value = "seat_id", type = IdType.AUTO)
    private Integer seatId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seat_info.filmHallNumber
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Integer filmHallNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seat_info.sequence
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Integer sequence;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seat_info.seatRow
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Integer seatRow;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seat_info.seatColumn
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Integer seatColumn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seat_info.isEnabled
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Boolean isEnabled;

    @TableField(exist = false)
    private String status;
}