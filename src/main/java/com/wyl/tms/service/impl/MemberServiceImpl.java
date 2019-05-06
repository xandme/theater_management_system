package com.wyl.tms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wyl.tms.common.ExtraResponse;
import com.wyl.tms.dao.MemberInfoMapper;
import com.wyl.tms.model.MemberInfo;
import com.wyl.tms.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yhw on 2019-05-06
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberInfoMapper, MemberInfo> implements MemberService {
    private final MemberInfoMapper memberInfoMapper;

    @Autowired
    public MemberServiceImpl(MemberInfoMapper memberInfoMapper) {
        this.memberInfoMapper = memberInfoMapper;
    }

    @Override
    public Object getList(Integer userId) {
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("user_id", userId);
        List<MemberInfo> memberInfoList = memberInfoMapper.selectList(entityWrapper);
        return new ExtraResponse(memberInfoList);
    }

    @Override
    public Object getDetail(Integer memberId) {
        MemberInfo memberInfo = memberInfoMapper.selectById(memberId);
        return new ExtraResponse(memberInfo);
    }
}
