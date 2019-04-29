package com.wyl.tms.service;

import com.baomidou.mybatisplus.service.IService;
import com.wyl.tms.model.CouponInfo;
import com.wyl.tms.model.GoodsInfo;
import com.wyl.tms.vo.GoodsOrder;

/**
 * Created by Yhw on 2019-04-28
 */
public interface CouponInfoService extends IService<CouponInfo> {
    Object getList(Integer pageNo, Integer pageSize, Integer status);
}
