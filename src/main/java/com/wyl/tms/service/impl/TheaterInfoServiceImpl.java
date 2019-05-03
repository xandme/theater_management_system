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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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
        List<FilmArrangement> filmArrangementList = filmArrangementMapper.findPage(filmId, page);
        DataList dataList = new DataList(page.getCurrent(), (int) page.getPages(), page.getSize(), (int) page.getTotal(), filmArrangementList);
        return new ExtraResponse(dataList);
    }

    @Override
    public Object getHallByFilmId(Integer filmId) {
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("film_id", filmId);
        List<FilmArrangement> filmArrangementList = filmArrangementMapper.selectList(entityWrapper);
        List<Integer> hallIdList = filmArrangementList.stream().map(filmArrangement -> filmArrangement.getFilmHallNumber()).collect(Collectors.toList());

//        FilmHallInfo filmHallInfo = new FilmHallInfo();
//        if (filmHallInfoList.size() > 0) {
//            filmHallInfo = filmHallInfoList.get(0);
//        }
        List<Date> dateList = filmArrangementMapper.selectDistinctDate(filmId);
        Map<String, List<FilmArrangement>> map = new HashMap<>();
        for (Date date : dateList) {
            List<FilmArrangement> list = new ArrayList<>();
            for (FilmArrangement filmArrangement : filmArrangementList) {
                if (date.compareTo(filmArrangement.getDate()) == 0) {
                    list.add(filmArrangement);
                }
            }
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
            String dateStr = sdf.format(date);
            map.put(dateStr, list);
        }
        return new ExtraResponse(map);
    }

    @Override
    public Object getArrangementDate(Integer pageNo, Integer pageSize, Integer theaterId, Integer filmId) {
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("film_id", filmId);
//        entityWrapper.ge("date", new Date());
        List<FilmArrangement> filmArrangementList = filmArrangementMapper.selectList(entityWrapper);
        return new ExtraResponse(filmArrangementList);
    }

    @Override
    public Object getTheaterDetail(Integer theaterId) {
        TheaterInfo theaterInfo = theaterInfoMapper.selectById(theaterId);
        return new ExtraResponse(theaterInfo);
    }
}
