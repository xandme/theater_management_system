package com.wyl.tms.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Yhw on 2019-04-22
 */
@JsonPropertyOrder({"error_code", "error_msg", "extra"})
public class ExtraResponse extends BaseResponse {

    @JsonProperty("extra")
    public Object extra;

    public ExtraResponse() {
        super();
    }

    public ExtraResponse(BaseResponse baseResponse, Object extra) {
        super(baseResponse.errorCode, baseResponse.errorMsg);
        this.extra = extra;
    }

    public ExtraResponse(Object extra) {
        this(BaseResponse.SUCCESS, extra);
    }

    public ExtraResponse(Integer errorCode, String errorMsg, Object extra) {
        this(new BaseResponse(errorCode, errorMsg), extra);
    }
}
