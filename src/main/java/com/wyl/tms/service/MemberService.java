package com.wyl.tms.service;

import com.baomidou.mybatisplus.service.IService;
import com.wyl.tms.model.MemberInfo;

/**
 * Created by Yhw on 2019-05-06
 */
public interface MemberService extends IService<MemberInfo> {
    Object getList(Integer userId);

    Object getDetail(Integer memberId);

    Object addMember(MemberInfo memberInfo);
}
