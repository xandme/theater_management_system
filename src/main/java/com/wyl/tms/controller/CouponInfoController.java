package com.wyl.tms.controller;

import com.wyl.tms.service.CouponInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Yhw on 2019-04-29
 */
@RestController
@RequestMapping("/couponinfo")
public class CouponInfoController {
    private final CouponInfoService couponInfoService;

    @Autowired
    public CouponInfoController(CouponInfoService couponInfoService) {
        this.couponInfoService = couponInfoService;
    }

    /**
     * 查看电影信息列表
     */
    @GetMapping("/list")
    public Object getFileList(@RequestParam(name = "page_no", required = false, defaultValue = "1") Integer pageNo,
                              @RequestParam(name = "page_size", required = false, defaultValue = "10") Integer pageSize,
                              @RequestParam(name = "status",required = false, defaultValue = "1") Integer status){
        return couponInfoService.getList(pageNo,pageSize,status);
    }
}
