package com.wyl.tms.controller;

import com.wyl.tms.service.UserService;
import com.wyl.tms.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/diy/login")
    public Object login(@RequestBody LoginVO login) {
        return userService.login(login);
    }
}
