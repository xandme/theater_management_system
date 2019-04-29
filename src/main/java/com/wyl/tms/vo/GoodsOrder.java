package com.wyl.tms.vo;

import com.wyl.tms.model.ChildGoodsOrder;
import lombok.Data;

import java.util.List;

/**
 * Created by Yhw on 2019-04-27
 */
@Data
public class GoodsOrder {
    private Integer userId;

    private Integer theaterId;

    private Integer couponId;

    private Integer goodsOrderPrice;

    private Integer actualPayPrice;

    private List<ChildGoodsOrder> goodsOrderList;
}
