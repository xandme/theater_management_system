package com.wyl.tms.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wyl.tms.common.DataList;
import com.wyl.tms.common.ExtraResponse;
import com.wyl.tms.dao.FilmInfoMapper;
import com.wyl.tms.dao.UserFilmOrderMapper;
import com.wyl.tms.model.FilmInfo;
import com.wyl.tms.model.UserFilmOrder;
import com.wyl.tms.model.UserGoodsOrder;
import com.wyl.tms.service.FilmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yhw on 2019-04-22
 */
@Service
public class FilmInfoServiceImpl extends ServiceImpl<FilmInfoMapper, FilmInfo> implements FilmInfoService {
    private final FilmInfoMapper filmInfoMapper;
    private final UserFilmOrderMapper userFilmOrderMapper;

    @Autowired
    public FilmInfoServiceImpl(FilmInfoMapper filmInfoMapper, UserFilmOrderMapper userFilmOrderMapper) {
        this.filmInfoMapper = filmInfoMapper;
        this.userFilmOrderMapper = userFilmOrderMapper;
    }


    @Override
    public Object getList(Integer pageNo, Integer pageSize, Integer status) {
        Page<FilmInfo> page = new Page<>(pageNo - 1, pageSize);
        List<FilmInfo> filmInfoList = filmInfoMapper.findPage(status, page);
        DataList dataList = new DataList(page.getCurrent(), (int) page.getPages(), page.getSize(), (int) page.getTotal(), filmInfoList);
        return new ExtraResponse(dataList);
    }

    @Override
    public Object getOrderList(Integer userId, Integer pageNo, Integer pageSize, Integer status) {
        Page<UserGoodsOrder> page = new Page<>(pageNo - 1, pageSize);
        List<UserFilmOrder> userFilmOrderList = userFilmOrderMapper.findPage(userId, status, page);
        DataList dataList = new DataList(page.getCurrent(), (int) page.getPages(), page.getSize(), (int) page.getTotal(), userFilmOrderList);
        return new ExtraResponse(dataList);
    }

    @Override
    public Object getFilmDetail(Integer id) {
        FilmInfo filmInfo = filmInfoMapper.selectById(id);
        return new ExtraResponse(filmInfo);
    }
}
