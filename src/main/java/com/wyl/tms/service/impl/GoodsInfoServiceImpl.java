package com.wyl.tms.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wyl.tms.common.BaseResponse;
import com.wyl.tms.common.DataList;
import com.wyl.tms.common.ExtraResponse;
import com.wyl.tms.dao.ChildGoodsOrderMapper;
import com.wyl.tms.dao.GoodsInfoMapper;
import com.wyl.tms.dao.UserGoodsOrderMapper;
import com.wyl.tms.model.ChildGoodsOrder;
import com.wyl.tms.model.GoodsInfo;
import com.wyl.tms.model.UserGoodsOrder;
import com.wyl.tms.service.GoodsInfoService;
import com.wyl.tms.vo.GoodsOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yhw on 2019-04-22
 */
@Service
public class GoodsInfoServiceImpl extends ServiceImpl<GoodsInfoMapper, GoodsInfo> implements GoodsInfoService {
    private final GoodsInfoMapper goodsInfoMapper;

    private final UserGoodsOrderMapper userGoodsOrderMapper;

    private final ChildGoodsOrderMapper childGoodsOrderMapper;

    @Autowired
    public GoodsInfoServiceImpl(GoodsInfoMapper goodsInfoMapper, UserGoodsOrderMapper userGoodsOrderMapper, ChildGoodsOrderMapper childGoodsOrderMapper) {
        this.goodsInfoMapper = goodsInfoMapper;
        this.userGoodsOrderMapper = userGoodsOrderMapper;
        this.childGoodsOrderMapper = childGoodsOrderMapper;
    }

    @Override
    public Object getList(Integer pageNo, Integer pageSize, Integer type, Integer theaterId) {
        Page<GoodsInfo> page = new Page<>(pageNo - 1, pageSize);
        List<GoodsInfo> goodsInfoList = goodsInfoMapper.findPage(theaterId, type, page);
        DataList dataList = new DataList(page.getCurrent(), (int) page.getPages(), page.getSize(), (int) page.getTotal(), goodsInfoList);
        return new ExtraResponse(dataList);
    }

    @Override
    public Object createOrder(GoodsOrder goodsOrder) {
        List<ChildGoodsOrder> childGoodsOrderList = goodsOrder.getGoodsOrderList();
        childGoodsOrderList.stream().forEach(childOrder -> childGoodsOrderMapper.insert(childOrder));
        UserGoodsOrder userGoodsOrder = new UserGoodsOrder();
        BeanUtils.copyProperties(goodsOrder, userGoodsOrder);
        userGoodsOrderMapper.insert(userGoodsOrder);
        return BaseResponse.SUCCESS;
    }

    @Override
    public Object getOrderList(Integer userId, Integer pageNo, Integer pageSize) {
        Page<UserGoodsOrder> page = new Page<>(pageNo - 1, pageSize);
        List<UserGoodsOrder> userGoodsOrderList = userGoodsOrderMapper.findPage(userId, page);
        DataList dataList = new DataList(page.getCurrent(), (int) page.getPages(), page.getSize(), (int) page.getTotal(), userGoodsOrderList);
        return new ExtraResponse(dataList);
    }
}
