package com.wyl.tms.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Yhw on 2019-04-22
 */
@JsonInclude(Include.NON_NULL)
public class BaseResponse {

    public static final int CODE_SUCCESS = 1000;
    public static final int CODE_INVALID_PARAM = 1001;
    public static final int CODE_SYSTEM_BUSY = 1002;
    public static final int CODE_CONNECTION_TIMEOUT = 1008;

    public static final int CODE_FAIL = 1009;

    public static final int CODE_EXCEPTION = 7005;

    public static final BaseResponse SUCCESS = new BaseResponse(CODE_SUCCESS, "");
    public static final BaseResponse SYSTEM_BUSY = new BaseResponse(CODE_SYSTEM_BUSY, "系统忙，请稍后再试(1002)");
    public final static BaseResponse INVALID_PARAM = new BaseResponse(CODE_INVALID_PARAM, "参数错误");
    public static final BaseResponse RSP_FAIL = new BaseResponse((1003), ("请求失败"));

    @JsonProperty("error_code")
    protected Integer errorCode;

    @JsonProperty("error_msg")
    protected String errorMsg;

    public BaseResponse() {
        this(BaseResponse.SUCCESS);
    }

    public BaseResponse(BaseResponse value) {
        this(value.errorCode, value.errorMsg);
    }

    public BaseResponse(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public static BaseResponse invalidParam(String paramName) {
        return new BaseResponse(CODE_INVALID_PARAM, paramName);
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static BaseResponse getInvalidParamResponse(String errMsg) {
        return new BaseResponse(CODE_INVALID_PARAM, errMsg);
    }

    public static BaseResponse getSystemBusyResponse(String errMsg) {
        return new BaseResponse(CODE_SYSTEM_BUSY, errMsg);
    }

    public static BaseResponse getDBFailResponse() {
        return new BaseResponse(CODE_SYSTEM_BUSY, "db error");
    }

    public static BaseResponse getPushMsgResponse(int errCode, String errMsg) {
        return new BaseResponse(errCode, errMsg);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return (this.errorCode == CODE_SUCCESS);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof BaseResponse)) {
            return false;
        }

        if (((BaseResponse) obj).getErrorCode() != this.getErrorCode()) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "BaseResponse [errorCode=" + errorCode + ", errorMsg=" + errorMsg + "]";
    }
}
