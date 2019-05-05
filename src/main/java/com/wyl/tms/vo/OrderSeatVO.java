package com.wyl.tms.vo;

import lombok.Data;

/**
 * Created by Yhw on 2019-05-05
 */
@Data
public class OrderSeatVO {
    private Integer seatId;
    private Integer seatRow;
    private Integer seatColumn;
    private Integer seatPrice;
}
