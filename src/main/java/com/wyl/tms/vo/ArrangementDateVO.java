package com.wyl.tms.vo;

import lombok.Data;

/**
 * Created by Yhw on 2019-05-04
 */
@Data
public class ArrangementDateVO {
    private String date;
    private String formatDate;

    public ArrangementDateVO(String date, String formatDate) {
        this.date = date;
        this.formatDate = formatDate;
    }
}
