package com.wyl.tms.controller;

import com.wyl.tms.service.FilmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Yhw on 2019-04-22
 */
@RestController
@RequestMapping("/filminfo")
public class FilmInfoController {
    private final FilmInfoService filmInfoService;

    @Autowired
    public FilmInfoController(FilmInfoService filmInfoService) {
        this.filmInfoService = filmInfoService;
    }


    /**
     * 查看电影信息列表
     */
    @GetMapping("/list")
    public Object getList(@RequestParam(name = "page_no", required = false, defaultValue = "1") Integer pageNo,
                          @RequestParam(name = "page_size", required = false, defaultValue = "10") Integer pageSize,
                          @RequestParam(name = "status", required = false) Integer status,
                          @RequestParam(name = "key", required = false) String key) {
        return filmInfoService.getList(pageNo, pageSize, status, key);
    }

    @GetMapping("/order/list")
    public Object getOrderList(@RequestHeader(value = "userId", defaultValue = "1") Integer userId,
                               @RequestParam(name = "page_no", required = false, defaultValue = "1") Integer pageNo,
                               @RequestParam(name = "page_size", required = false, defaultValue = "10") Integer pageSize,
                               @RequestParam(name = "status", required = false, defaultValue = "1") Integer status) {
        return filmInfoService.getOrderList(userId, pageNo, pageSize, status);
    }

    /**
     * 查看电影详情
     */
    @GetMapping("/{id}/detail")
    public Object getFilmDetail(@PathVariable("id") Integer id) {
        return filmInfoService.getFilmDetail(id);
    }

}
