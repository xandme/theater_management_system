package com.wyl.tms.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Created by Yhw on 2019-05-04
 */
@Data
public class FilmHallVO {
    private Integer arrangementId;

    private Integer filmId;

    private Integer filmHallNumber;

    private Integer theaterId;

    private Integer seatQuantity;

    private Double price;

    private Date date;

    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    private Date time;

    private String filmHallName;

    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    private Date offTime;

    private String language;
}
