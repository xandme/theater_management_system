package com.wyl.tms.common;

import lombok.Getter;

@Getter
public enum REnum {

    LOGINOUT_SUCCESS(3,"注销成功")
    ,LOGIN_SUCCESS(2,"登陆成功")
    ,SUCCESS(1,"成功")
    ,UNKNOWN_ERR(-999,"未知错误")
    ,COMMON_ERR(-1,"一般性错误")
    ,EXISTS_ERR(-3,"信息重复错误")
    ,NOEXISTS_ERR(-4,"信息不存在错误")
    ,NOLOGIN_ERR(-20,"您未登录")
    ,VERIFYCODE_ERR(-21,"验证码错误")
    ,LOGIN_NORMAL_ERR(-22,"错误的用户名或密码")
    ,LOGIN_AGAIN_ERR(-23,"你已经登录")
    ,LOGINOUT_ERR(-25,"您现已不在线")
    ,FIELD_VALID_ERR(-30, "字段不合法")
    ,UPDATE_INFO_ERR(-40,"在数据库中找不到与更新信息id对应的条目")
    ,PERMISSION_DENIED(-110,"权限不足")
    ,REQUEST_PARAM_ERR(-100,"请求参数错误")
    ;
    private Integer code;
    private String msg;

    REnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
