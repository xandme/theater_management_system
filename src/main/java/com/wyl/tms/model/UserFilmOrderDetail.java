package com.wyl.tms.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/**
 * Created by Yhw on 2019-05-05
 */
@Data
public class UserFilmOrderDetail {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer orderId;
    private Integer seatId;
    private Integer seatRow;
    private Integer seatColumn;
    private Double seatPrice;
}
