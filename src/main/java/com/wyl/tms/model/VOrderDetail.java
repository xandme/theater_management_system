package com.wyl.tms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wyl.tms.vo.OrderSeatVO;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by Yhw on 2019-05-04
 * 此为视图，非实体
 */
@Data
public class VOrderDetail {
    private Integer orderId;
    private Integer orderStatus;
    private Double orderAmount;
    private Integer ticketQuantity;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date createdTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date updatedTime;
    private Integer arrangementId;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    private Date time;
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    private Date offTime;
    private Integer filmHallNumber;
    private String filmHallName;
    private Integer theaterId;
    private String theaterName;
    private String theaterDescription;
    private Integer filmId;
    private String filmName;
    private String url;
}
