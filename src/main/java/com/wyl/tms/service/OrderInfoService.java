package com.wyl.tms.service;

import com.wyl.tms.vo.ConfirmSeatVO;

/**
 * Created by Yhw on 2019-05-04
 */
public interface OrderInfoService {
    Object getFilmOrderList(Integer pageNo, Integer pageSize, Integer status, Integer userId);

    Object confirmSeat(Integer userId, ConfirmSeatVO confirmSeatVO);
}
