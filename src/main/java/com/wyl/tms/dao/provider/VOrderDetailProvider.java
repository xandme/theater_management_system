package com.wyl.tms.dao.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Yhw on 2019-05-04
 */
public class VOrderDetailProvider {
    public String findDetailPage(@Param("status") Integer status, @Param("userId") Integer userId) {
        return new SQL() {
            {
                SELECT("*")
                        .FROM("v_order_detail")
                        .WHERE("user_id = #{userId}");
                if (status != null) {
                    WHERE("order_status = #{status}");
                }
                ORDER_BY("created_time");
            }
        }.toString();
    }
}
