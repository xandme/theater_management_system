package com.wyl.tms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wyl.tms.dao.UserMapper;
import com.wyl.tms.model.User;
import com.wyl.tms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Yhw on 2019-04-26
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        log.info("用户名：" + username);
////        EntityWrapper entityWrapper = new EntityWrapper();
////        entityWrapper.eq("username", username);
////        List<User> userList = userMapper.selectList(entityWrapper);
////        if (userList.isEmpty()) {
////            throw  new RuntimeException("用户不存在");
////        }
////        User user = userList.get(0);
////        return new CustomUserDetails(new User(user.getUsername(),user.getPassword()));
//        return new CustomUserDetails(new User("test1",new BCryptPasswordEncoder().encode("123456")));
//    }
}
