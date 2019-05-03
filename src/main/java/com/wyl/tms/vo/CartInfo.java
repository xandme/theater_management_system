package com.wyl.tms.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by Yhw on 2019-05-03
 */
@Data
public class CartInfo {
    private Double totalPrice;
    private List<CartItem> list;
}
