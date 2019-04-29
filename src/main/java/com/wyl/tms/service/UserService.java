package com.wyl.tms.service;

import com.baomidou.mybatisplus.service.IService;
import com.wyl.tms.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Yhw on 2019-04-27
 */
public interface UserService extends UserDetailsService,IService<User> {
}
