package com.wyl.tms.common;

import lombok.Getter;

/**
 * Created by Yhw on 2019-05-05
 */
@Getter
public enum OrderStatusEnum {
    NOT_PAY(0, "未付款"),

    EXPIRED(1, "已售出"),

    PAYED(2, "待使用"),

    EVALUATED(3, "待评价");

    private Integer code;
    private String desc;

    OrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
