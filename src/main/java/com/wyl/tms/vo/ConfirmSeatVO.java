package com.wyl.tms.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by Yhw on 2019-05-05
 */
@Data
public class ConfirmSeatVO {
    private Integer arrangementId;
    private List<String> selectedList;
    private Double totalAmount;
    private Integer hallId;
    private Double price;
}
