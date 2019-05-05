package com.wyl.tms.service;

import com.baomidou.mybatisplus.service.IService;
import com.wyl.tms.model.FilmInfo;

/**
 * Created by Yhw on 2019-04-22
 */
public interface FilmInfoService extends IService<FilmInfo> {
    Object getList(Integer pageNo, Integer pageSize,Integer status);

    Object getOrderList(Integer userId, Integer pageNo, Integer pageSize, Integer status);

    Object getFilmDetail(Integer id);
}
