package com.wyl.tms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wyl.tms.common.BaseResponse;
import com.wyl.tms.common.ExtraResponse;
import com.wyl.tms.dao.UserMapper;
import com.wyl.tms.model.User;
import com.wyl.tms.service.UserService;
import com.wyl.tms.util.CodeUtils;
import com.wyl.tms.vo.LoginVO;
import com.wyl.tms.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    @Override
    public Object getUserInfoOne(Integer userId) {
        try {
            User user = userMapper.selectById(userId);
            return new ExtraResponse(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object login(LoginVO map) {
        try {
            String md5Passord = CodeUtils.md5Hex(map.getPassword());
//            User user = userMapper.findByName(map.getUsername());
            User user = userMapper.findByTelephone(map.getUsername());
            if (md5Passord.equals(user.getPassword())) {
                UserVO userVO = new UserVO();
                BeanUtils.copyProperties(user, userVO);
                userVO.setHeadPhotoUrl(user.getHeadPhotoURL());
                UserVO.Security security = new UserVO.Security(UUID.randomUUID().toString().replace("-", ""), 30);
                userVO.setSecurity(security);
                return new ExtraResponse(userVO);
            } else {
                return new BaseResponse(1001, "用户名或密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(CodeUtils.md5Hex("123456"));
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
