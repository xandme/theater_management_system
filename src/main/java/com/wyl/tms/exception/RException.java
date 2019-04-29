package com.wyl.tms.exception;

import com.wyl.tms.common.REnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 增强运行时异常，称为结果异常
 */
@Getter
@Setter
public class RException extends  Exception{

    private Integer code;
    private Object data;


    public RException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public RException(Integer code, String msg, Object data) {
        super(msg);
        this.code = code;
        this.data = data;
    }

    public RException(REnum rEnum) {
        super(rEnum.getMsg());
        this.code = rEnum.getCode();
    }
    public RException(REnum rEnum, Object data) {
        super(rEnum.getMsg());
        this.code = rEnum.getCode();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
