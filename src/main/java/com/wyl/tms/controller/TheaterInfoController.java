package com.wyl.tms.controller;

import com.wyl.tms.service.TheaterInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Yhw on 2019-04-23
 */
@RestController
@RequestMapping("/theaterinfo")
public class TheaterInfoController {
    private final TheaterInfoService theaterInfoService;

    @Autowired
    public TheaterInfoController(TheaterInfoService theaterInfoService) {
        this.theaterInfoService = theaterInfoService;
    }

    /**
     * 查看影院信息列表
     */
    @GetMapping("/list")
    public Object getList(@RequestParam(name = "page_no", required = false, defaultValue = "1") Integer pageNo,
                          @RequestParam(name = "page_size", required = false, defaultValue = "10") Integer pageSize,
                          @RequestParam(name = "type", required = false, defaultValue = "1") Integer type,
                          @RequestParam(name = "theater_id", required = false, defaultValue = "1") Integer theaterId) {
        return theaterInfoService.getList(pageNo, pageSize);
    }

    /**
     * 查看电影排片信息列表
     */
    @GetMapping("/arrangement/list")
    public Object getArrangementList(@RequestParam(name = "theater_id") Integer theaterId,
                              @RequestParam(name = "film_id") Integer filmId,
                              @RequestParam(name = "page_no", required = false, defaultValue = "1") Integer pageNo,
                              @RequestParam(name = "page_size", required = false, defaultValue = "10") Integer pageSize) {
        return theaterInfoService.getArrangementList(pageNo, pageSize, theaterId, filmId);
    }

    /**
     * 根据电影id,查看影厅信息
     */
    @GetMapping("/film/{id}/hall")
    public Object getHallByFilmId(@PathVariable(name = "id") Integer arrangementId) {
        return theaterInfoService.getHallByArrangementId(arrangementId);
    }
}
