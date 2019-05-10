package com.wyl.tms.controller;

import com.wyl.tms.service.OrderInfoService;
import com.wyl.tms.vo.ConfirmSeatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Yhw on 2019-05-04
 */
@RestController
@RequestMapping("/order")
public class OrderInfoController {
    private final OrderInfoService orderInfoService;

    @Autowired
    public OrderInfoController(OrderInfoService orderInfoService) {
        this.orderInfoService = orderInfoService;
    }

    /**
     * 获取电影订单信息
     */
    @GetMapping("/film/list")
    public Object getFilmOrderList(@RequestHeader(value = "user_id", defaultValue = "1") Integer userId,
                                   @RequestParam(name = "page_no", required = false, defaultValue = "1") Integer pageNo,
                                   @RequestParam(name = "page_size", required = false, defaultValue = "10") Integer pageSize,
                                   @RequestParam(name = "status", required = false) Integer status) {
        return orderInfoService.getFilmOrderList(pageNo, pageSize, status, userId);
    }

    /**
     * 确认选座
     */
    @PostMapping("/confirm/seat")
    public Object confirmSeat(@RequestHeader(name = "user_id", defaultValue = "1") Integer userId,
                              @RequestBody ConfirmSeatVO confirmSeatVO) {
        return orderInfoService.confirmSeat(userId,confirmSeatVO);
    }

    /**
     * 获取订单详情
     */
    @GetMapping("/{id}/detail")
    public Object getDetail(@PathVariable("id")Integer id){
        return orderInfoService.getDetail(id);
    }

    /**
     * 确认付款
     */
    @GetMapping("/{id}/confirm")
    public Object confirmOrder(@PathVariable("id")Integer id){
        return orderInfoService.confirmOrder(id);
    }
}
