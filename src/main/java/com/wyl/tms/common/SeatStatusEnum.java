package com.wyl.tms.common;

import lombok.Getter;

/**
 * Created by Yhw on 2019-05-05
 */
@Getter
public enum SeatStatusEnum {
    AVAILABLE("可选座位"),
    UNAVAILABLE("已售出"),
    SELECTED("已选择");


    private String desc;

    SeatStatusEnum(String desc) {
        this.desc = desc;
    }
}
