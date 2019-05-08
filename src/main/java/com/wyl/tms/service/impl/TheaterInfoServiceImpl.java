package com.wyl.tms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wyl.tms.common.*;
import com.wyl.tms.dao.*;
import com.wyl.tms.model.FilmArrangement;
import com.wyl.tms.model.SeatInfo;
import com.wyl.tms.model.SeatSelectionSituation;
import com.wyl.tms.model.TheaterInfo;
import com.wyl.tms.service.TheaterInfoService;
import com.wyl.tms.vo.ArrangementDateVO;
import com.wyl.tms.vo.FilmHallVO;
import com.wyl.tms.vo.SeatChartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Yhw on 2019-04-23
 */
@Service
public class TheaterInfoServiceImpl extends ServiceImpl<TheaterInfoMapper, TheaterInfo> implements TheaterInfoService {
    private final TheaterInfoMapper theaterInfoMapper;

    private final FilmArrangementMapper filmArrangementMapper;

    private final FilmHallInfoMapper filmHallInfoMapper;

    private final SeatSelectionSituationMapper situationMapper;

    private final SeatInfoMapper seatInfoMapper;

    @Autowired
    public TheaterInfoServiceImpl(TheaterInfoMapper theaterInfoMapper, FilmArrangementMapper filmArrangementMapper, FilmHallInfoMapper filmHallInfoMapper, SeatSelectionSituationMapper situationMapper, SeatInfoMapper seatInfoMapper) {
        this.theaterInfoMapper = theaterInfoMapper;
        this.filmArrangementMapper = filmArrangementMapper;
        this.filmHallInfoMapper = filmHallInfoMapper;
        this.situationMapper = situationMapper;
        this.seatInfoMapper = seatInfoMapper;
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
        List<FilmArrangement> filmArrangementList = filmArrangementMapper.findPageByTheaterId(filmId, theaterId, page);
        DataList dataList = new DataList(page.getCurrent(), (int) page.getPages(), page.getSize(), (int) page.getTotal(), filmArrangementList);
        return new ExtraResponse(dataList);
    }

    @Override
    public Object getArrangementDate(Integer pageNo, Integer pageSize, Integer theaterId, Integer filmId) {
        List<Date> dateList = filmArrangementMapper.selectDistinctDate(filmId, theaterId);
        List<ArrangementDateVO> dateVOList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("M月d日");
        SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd");
        for (Date date : dateList) {
            String formatDate = sdf.format(date);
            String dateStr = sdf1.format(date);
            dateVOList.add(new ArrangementDateVO(dateStr, formatDate));

        }
        return new ExtraResponse(dateVOList);
    }

    @Override
    public Object getTheaterDetail(Integer theaterId) {
        TheaterInfo theaterInfo = theaterInfoMapper.selectById(theaterId);
        return new ExtraResponse(theaterInfo);
    }

    @Override
    public Object getFilmHallList(Integer filmId, Integer theaterId, String date) {
        List<FilmHallVO> filmHallVOList = filmArrangementMapper.selectFilmHall(filmId, theaterId, date);
        return new ExtraResponse(filmHallVOList);
    }

    private final static String SEAT_MARK = "c";
    private final static String PASSAGE_MARK = "_";

    @Override
    public Object getArrangementHallSeat(Integer arrangementId, Integer hallId) {
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("film_hall_number", hallId);
        List<SeatInfo> seatInfoList = seatInfoMapper.selectList(entityWrapper);
        EntityWrapper entityWrapper1 = new EntityWrapper();
        entityWrapper1.eq("arrangement_id", arrangementId);
        List<SeatSelectionSituation> situationList = situationMapper.selectList(entityWrapper1);
        List<String> unavailableSeatList = new ArrayList<>();

        //将同行的位置分组存放
        Map<Integer, Map<Integer, SeatInfo>> seatInfoMap = new HashMap<>();
        for (SeatInfo seatInfo : seatInfoList) {
            seatInfo.setStatus(SeatStatusEnum.AVAILABLE.name());
            if (!seatInfo.getIsEnabled()) {
                seatInfo.setStatus(SeatStatusEnum.UNAVAILABLE.name());
            }
            for (SeatSelectionSituation situation : situationList) {
                if (situation.getSeatId().equals(seatInfo.getSeatId())) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(seatInfo.getSeatRow()).append("_").append(seatInfo.getSeatColumn());
                    unavailableSeatList.add(sb.toString());
                    seatInfo.setStatus(SeatStatusEnum.UNAVAILABLE.name());
                }
            }
            if (seatInfoMap.containsKey(seatInfo.getSeatRow())) {
                seatInfoMap.get(seatInfo.getSeatRow()).put(seatInfo.getSeatColumn(), seatInfo);
            } else {
                Map<Integer, SeatInfo> tmpMap = new HashMap<>();
                tmpMap.put(seatInfo.getSeatColumn(), seatInfo);
                seatInfoMap.put(seatInfo.getSeatRow(), tmpMap);
            }
        }
        //空位用空实体占位
        List<String> stringList = new ArrayList<>();
        for (Integer i = 1; i < SeatConst.ROW_COUNT + 1; i++) {
            Map<Integer, SeatInfo> map = seatInfoMap.get(i);
            Map<Integer, SeatInfo> tempMap = new HashMap<>();
            StringBuffer sb = new StringBuffer();
            if (map == null) {
                for (Integer j = 1; j < SeatConst.COL_COUNT + 1; j++) {
                    tempMap.put(j, new SeatInfo());
                    sb.append(PASSAGE_MARK);
                }
            } else {
                for (Integer j = 1; j < SeatConst.COL_COUNT + 1; j++) {
                    if (map.get(j) == null) {
                        tempMap.put(j, new SeatInfo());
                        sb.append(PASSAGE_MARK);
                    } else {
                        tempMap.put(j, map.get(j));
                        sb.append(SEAT_MARK);
                    }
                }
            }
            seatInfoMap.put(i, tempMap);
            stringList.add(sb.toString());
        }
        return new ExtraResponse(new SeatChartVO(stringList, unavailableSeatList));
    }

    @Override
    public Object getArrangementDetail(Integer arrangementId) {
        FilmArrangement filmArrangement = filmArrangementMapper.selectById(arrangementId);
        return new ExtraResponse(filmArrangement);
    }

    @Override
    public Object getDefault(Integer theaterId) {
        if (Objects.isNull(theaterId)) {
            List<TheaterInfo> theaterInfoList = theaterInfoMapper.selectList(new EntityWrapper<>());
            if (theaterInfoList.size() > 0) {
                return new ExtraResponse(theaterInfoList.get(0));
            }
            return BaseResponse.CODE_FAIL;
        } else {
            return new ExtraResponse(theaterInfoMapper.selectById(theaterId));
        }
    }
}
