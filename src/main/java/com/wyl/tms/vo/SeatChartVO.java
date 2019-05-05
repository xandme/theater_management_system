package com.wyl.tms.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Yhw on 2019-05-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatChartVO {
    private List<String> seatList;

    private List<String> unavailableSeatList;
}
