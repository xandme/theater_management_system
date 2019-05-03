package com.wyl.tms.vo;

import lombok.Data;

/**
 * Created by Yhw on 2019-05-03
 */
@Data
public class CartItem {
    private Integer goodsId;
    private Integer quantity;
    private Double goodsPrice;
    private Double priceSum;
}
