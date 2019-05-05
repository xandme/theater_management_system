package com.wyl.tms.vo;

import lombok.Data;

/**
 * Created by Yhw on 2019-05-04
 */
@Data
public class SeatInfoVO {
    private Integer seatId;

    private Integer filmHallNumber;

    private Integer sequence;

    private Integer seatRow;

    private Integer seatColumn;

    private Boolean isEnabled;

    private Integer status;
}
