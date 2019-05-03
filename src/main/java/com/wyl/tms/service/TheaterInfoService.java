package com.wyl.tms.service;

import com.baomidou.mybatisplus.service.IService;
import com.wyl.tms.model.TheaterInfo;

/**
 * Created by Yhw on 2019-04-23
 */
public interface TheaterInfoService extends IService<TheaterInfo> {
    Object getList(Integer pageNo, Integer pageSize);

    Object getArrangementList(Integer pageNo, Integer pageSize, Integer theaterId, Integer filmId);

    Object getHallByFilmId(Integer filmId);

    Object getArrangementDate(Integer pageNo, Integer pageSize, Integer theaterId, Integer filmId);

    Object getTheaterDetail(Integer theaterId);
}
