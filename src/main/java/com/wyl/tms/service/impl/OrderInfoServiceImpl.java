package com.wyl.tms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wyl.tms.common.BaseResponse;
import com.wyl.tms.common.DataList;
import com.wyl.tms.common.ExtraResponse;
import com.wyl.tms.common.OrderStatusEnum;
import com.wyl.tms.dao.SeatInfoMapper;
import com.wyl.tms.dao.SeatSelectionSituationMapper;
import com.wyl.tms.dao.UserFilmOrderDetailMapper;
import com.wyl.tms.dao.UserFilmOrderMapper;
import com.wyl.tms.model.*;
import com.wyl.tms.service.OrderInfoService;
import com.wyl.tms.vo.ConfirmSeatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Yhw on 2019-05-04
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    private final UserFilmOrderMapper userFilmOrderMapper;
    private final SeatInfoMapper seatInfoMapper;
    private final UserFilmOrderDetailMapper userFilmOrderDetailMapper;
    private final SeatSelectionSituationMapper situationMapper;

    @Autowired
    public OrderInfoServiceImpl(UserFilmOrderMapper userFilmOrderMapper, SeatInfoMapper seatInfoMapper, UserFilmOrderDetailMapper userFilmOrderDetailMapper, SeatSelectionSituationMapper situationMapper) {
        this.userFilmOrderMapper = userFilmOrderMapper;
        this.seatInfoMapper = seatInfoMapper;
        this.userFilmOrderDetailMapper = userFilmOrderDetailMapper;
        this.situationMapper = situationMapper;
    }

    @Override
    public Object getFilmOrderList(Integer pageNo, Integer pageSize, Integer status, Integer userId) {
        Page<VOrderDetail> page = new Page<>(pageNo - 1, pageSize);
        List<VOrderDetail> vOrderDetailList = userFilmOrderMapper.findDetailPage(status, userId, page);
        DataList dataList = new DataList(page.getCurrent(), (int) page.getPages(), page.getSize(), (int) page.getTotal(), vOrderDetailList);
        return new ExtraResponse(dataList);
    }

    @Override
    public Object confirmSeat(Integer userId, ConfirmSeatVO confirmSeatVO) {
        UserFilmOrder userFilmOrder = new UserFilmOrder();
        userFilmOrder.setUserId(userId);
        userFilmOrder.setOrderAmount(confirmSeatVO.getTotalAmount());
        userFilmOrder.setArrangementId(confirmSeatVO.getArrangementId());
        userFilmOrder.setOrderStatus(OrderStatusEnum.NOT_PAY.getCode());
        userFilmOrder.setTicketQuantity(confirmSeatVO.getSelectedList().size());
        userFilmOrder.setCreatedTime(new Date());
        userFilmOrderMapper.insert(userFilmOrder);

        for (String str : confirmSeatVO.getSelectedList()) {
            String[] rc = str.split("_");
            EntityWrapper entityWrapper = new EntityWrapper();
            entityWrapper.eq("film_hall_number", confirmSeatVO.getHallId())
                    .eq("seat_row", rc[0])
                    .eq("seat_column", rc[1]);
            List<SeatInfo> seatInfoList = seatInfoMapper.selectList(entityWrapper);
            SeatInfo seatInfo = seatInfoList.get(0);
            //todo 两个保存信息类似，感觉后期优化可以删除，暂做保留
            // 保存订单详情
            UserFilmOrderDetail detail = new UserFilmOrderDetail();
            detail.setOrderId(userFilmOrder.getFilmOrderId());
            detail.setSeatId(seatInfo.getSeatId());
            detail.setSeatRow(seatInfo.getSeatRow());
            detail.setSeatColumn(seatInfo.getSeatColumn());
            userFilmOrderDetailMapper.insert(detail);
            // 保存已选座位（主要是为了方便查询已选座位）
            SeatSelectionSituation situation = new SeatSelectionSituation();
            situation.setArrangementId(confirmSeatVO.getArrangementId());
            situation.setFilmOrderId(userFilmOrder.getFilmOrderId());
            situation.setSeatStatus(1);
            situation.setSeatId(seatInfo.getSeatId());
            situationMapper.insert(situation);
        }
        return BaseResponse.SUCCESS;
    }
}
