package com.wyl.tms.controller;

import com.wyl.tms.service.GoodsInfoService;
import com.wyl.tms.vo.CartInfo;
import com.wyl.tms.vo.CartItem;
import com.wyl.tms.vo.GoodsOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yhw on 2019-04-23
 */
@RestController
@RequestMapping("/goodsinfo")
public class GoodsInfoController {
    private final GoodsInfoService goodsInfoService;

    @Autowired
    public GoodsInfoController(GoodsInfoService goodsInfoService) {
        this.goodsInfoService = goodsInfoService;
    }

    /**
     * 查看商品信息列表
     */
    @GetMapping("/list")
    public Object getList(@RequestParam(name = "page_no", required = false, defaultValue = "1") Integer pageNo,
                          @RequestParam(name = "page_size", required = false, defaultValue = "10") Integer pageSize,
                          @RequestParam(name = "type", required = false, defaultValue = "1") Integer type,
                          @RequestParam(name = "theater_id", required = false, defaultValue = "1") Integer theaterId) {
        return goodsInfoService.getList(pageNo, pageSize, type, theaterId);
    }

    /**
     * 创建商品订单
     */
    @PostMapping("/order/create")
    public Object createOrder(@RequestBody GoodsOrder goodsOrder) {
        return goodsInfoService.createOrder(goodsOrder);
    }

    /**
     * 查看商品订单列表
     */
    @GetMapping("/order/list")
    public Object getOrderList(@RequestHeader("user_id") Integer userId,
                               @RequestParam(name = "page_no", required = false, defaultValue = "1") Integer pageNo,
                               @RequestParam(name = "page_size", required = false, defaultValue = "10") Integer pageSize,
                               @RequestParam(name = "status") Integer status) {
        return goodsInfoService.getOrderList(userId, pageNo, pageSize, status);
    }

    /**
     * 查看商品订单的详情
     */
    @GetMapping("/order/{id}/detail")
    public Object getOrderDetail(@PathVariable(name = "id") Integer orderId) {
        return goodsInfoService.getOrderDetail(orderId);
    }

    /**
     * 结算商品购物车
     */
    @PostMapping("/order/checkout")
    public Object checkoutOrder(@RequestHeader(value = "userId", defaultValue = "1") Integer userId,
                                @RequestHeader(value = "theaterId", defaultValue = "1") Integer theaterId,
                                @RequestBody CartInfo cartInfo) {
        return goodsInfoService.checkoutOrder(userId, theaterId, cartInfo);
    }
}
