package com.wyl.tms.service;

import com.baomidou.mybatisplus.service.IService;
import com.wyl.tms.model.User;

import java.util.Map;

/**
 * Created by Yhw on 2019-04-27
 */
public interface UserService extends IService<User> {
    Object getUserInfoOne(Integer userId);

    Object login(Map map);
}
