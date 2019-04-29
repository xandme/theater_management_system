package com.wyl.tms.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wyl.tms.common.DataList;
import com.wyl.tms.common.ExtraResponse;
import com.wyl.tms.dao.CouponInfoMapper;
import com.wyl.tms.model.CouponInfo;
import com.wyl.tms.model.FilmInfo;
import com.wyl.tms.service.CouponInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yhw on 2019-04-27
 */
@Service
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo> implements CouponInfoService {
    private final CouponInfoMapper couponInfoMapper;

    @Autowired
    public CouponInfoServiceImpl(CouponInfoMapper couponInfoMapper) {
        this.couponInfoMapper = couponInfoMapper;
    }


    @Override
    public Object getList(Integer pageNo, Integer pageSize, Integer status) {
        Page<CouponInfo> page = new Page<>(pageNo - 1, pageSize);
        List<CouponInfo> couponInfoList = couponInfoMapper.findPage(page);
        DataList dataList = new DataList(page.getCurrent(), (int) page.getPages(), page.getSize(), (int) page.getTotal(), couponInfoList);
        return new ExtraResponse(dataList);
    }
}
