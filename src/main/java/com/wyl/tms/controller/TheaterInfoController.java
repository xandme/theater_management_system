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
     * 返回影院信息
     */
    @GetMapping("/default")
    public Object TheaterDefault(@RequestParam(value = "id", required = false) Integer theaterId) {
        return theaterInfoService.getDefault(theaterId);
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
    @GetMapping("/arrangement/{id}/list")
    public Object getArrangementList(@RequestParam(name = "theater_id", defaultValue = "1") Integer theaterId,
                                     @PathVariable(name = "id") Integer filmId,
                                     @RequestParam(name = "page_no", required = false, defaultValue = "1") Integer pageNo,
                                     @RequestParam(name = "page_size", required = false, defaultValue = "10") Integer pageSize) {
        return theaterInfoService.getArrangementList(pageNo, pageSize, theaterId, filmId);
    }

    /**
     * 获取电影放映日期
     */
    @GetMapping("/arrangement/{id}/date")
    public Object getArrangementDate(@RequestParam(name = "theater_id", defaultValue = "1") Integer theaterId,
                                     @PathVariable(name = "id") Integer filmId,
                                     @RequestParam(name = "page_no", required = false, defaultValue = "1") Integer pageNo,
                                     @RequestParam(name = "page_size", required = false, defaultValue = "10") Integer pageSize) {
        return theaterInfoService.getArrangementDate(pageNo, pageSize, theaterId, filmId);
    }

    /**
     * 根据电影id,查看影厅信息
     */
    @GetMapping("/hall/{id}/list")
    public Object getFilmHallList(@PathVariable(name = "id") Integer filmId,
                                  @RequestParam(name = "theater_id") Integer theaterId, String date) {
        return theaterInfoService.getFilmHallList(filmId, theaterId, date);
    }

    /**
     * 获取影院详情
     */
    @GetMapping("/{id}/detail")
    public Object getTheaterDetail(@PathVariable(name = "id") Integer theaterId) {
        return theaterInfoService.getTheaterDetail(theaterId);

    }

    /**
     * 获取影厅座位数据
     */
    @GetMapping("/arrangement/hall/seat")
    public Object getArrangementHallSeat(@RequestParam("arrangement_id") Integer arrangementId,
                                         @RequestParam("hall_id") Integer hallId) {
        return theaterInfoService.getArrangementHallSeat(arrangementId, hallId);
    }

    /**
     * 获取影厅座位数据
     */
    @GetMapping("/arrangement/{id}/detail")
    public Object getArrangementDetail(@PathVariable("id") Integer arrangementId) {
        return theaterInfoService.getArrangementDetail(arrangementId);
    }
}
