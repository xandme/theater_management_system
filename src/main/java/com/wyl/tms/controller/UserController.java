package com.wyl.tms.controller;

import com.wyl.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 查看用户信息
     */
    @GetMapping("/{userId}/detail")
    public Object getUserInfoOne(@PathVariable("userId") Integer userId) {
        Object userone = userService.getUserInfoOne(userId);
        System.out.println(userone);
        return userone;
    }
}
