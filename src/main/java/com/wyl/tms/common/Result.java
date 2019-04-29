package com.wyl.tms.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 统一返回结果
 * @param <T>
 */
@Getter
@Setter
public class Result<T> {
    /*
        信息代码
     */
    private Integer code;
    /*
        返回消息
     */
    private String msg;
    /*
        返回数据
     */
    private T data;

    public Result() {
    }

    public Result(REnum rEnum)
    {
        this.code=rEnum.getCode();
        this.msg=rEnum.getMsg();
        this.data=null;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
