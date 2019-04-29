package com.wyl.tms.service;

import com.baomidou.mybatisplus.service.IService;
import com.wyl.tms.model.FilmInfo;
import com.wyl.tms.model.GoodsInfo;
import com.wyl.tms.vo.GoodsOrder;

/**
 * Created by Yhw on 2019-04-22
 */
public interface GoodsInfoService extends IService<GoodsInfo> {
    Object getList(Integer pageNo, Integer pageSize, Integer type, Integer theaterId);

    Object createOrder(GoodsOrder goodsOrder);

    Object getOrderList(Integer userId, Integer pageNo, Integer pageSize);
}
