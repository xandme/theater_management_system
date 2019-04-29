package com.wyl.tms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wyl.tms.common.DataList;
import com.wyl.tms.common.ExtraResponse;
import com.wyl.tms.dao.FilmArrangementMapper;
import com.wyl.tms.dao.FilmHallInfoMapper;
import com.wyl.tms.dao.TheaterInfoMapper;
import com.wyl.tms.model.FilmArrangement;
import com.wyl.tms.model.FilmHallInfo;
import com.wyl.tms.model.TheaterInfo;
import com.wyl.tms.service.TheaterInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yhw on 2019-04-23
 */
@Service
public class TheaterInfoServiceImpl extends ServiceImpl<TheaterInfoMapper, TheaterInfo> implements TheaterInfoService {
    private final TheaterInfoMapper theaterInfoMapper;

    private final FilmArrangementMapper filmArrangementMapper;

    private final FilmHallInfoMapper filmHallInfoMapper;

    @Autowired
    public TheaterInfoServiceImpl(TheaterInfoMapper theaterInfoMapper, FilmArrangementMapper filmArrangementMapper, FilmHallInfoMapper filmHallInfoMapper) {
        this.theaterInfoMapper = theaterInfoMapper;
        this.filmArrangementMapper = filmArrangementMapper;
        this.filmHallInfoMapper = filmHallInfoMapper;
    }

    @Override
    public Object getList(Integer pageNo, Integer pageSize) {
        Page<TheaterInfo> page = new Page<>(pageNo - 1, pageSize);
        List<TheaterInfo> theaterInfoList = theaterInfoMapper.findPage(page);
        DataList dataList = new DataList(page.getCurrent(), (int) page.getPages(), page.getSize(), (int) page.getTotal(), theaterInfoList);
        return new ExtraResponse(dataList);
    }

    @Override
    public Object getArrangementList(Integer pageNo, Integer pageSize, Integer theaterId, Integer filmId) {
        Page<FilmArrangement> page = new Page<>(pageNo - 1, pageSize);
        List<FilmArrangement> filmArrangementList = filmArrangementMapper.findPage(theaterId, filmId, page);
        DataList dataList = new DataList(page.getCurrent(), (int) page.getPages(), page.getSize(), (int) page.getTotal(), filmArrangementList);
        return new ExtraResponse(dataList);
    }

    @Override
    public Object getHallByArrangementId(Integer arrangementId) {
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("arrangement_id", arrangementId);
        List<FilmHallInfo> filmHallInfoList = filmHallInfoMapper.selectList(entityWrapper);
        FilmHallInfo filmHallInfo = new FilmHallInfo();
        if (filmHallInfoList.size() > 0) {
            filmHallInfo = filmHallInfoList.get(0);
        }
        return new ExtraResponse(filmHallInfo);
    }
}
