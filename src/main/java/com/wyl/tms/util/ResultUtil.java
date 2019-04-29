package com.wyl.tms.util;

import com.wyl.tms.common.REnum;
import com.wyl.tms.common.Result;

public class ResultUtil {
    public static Result success(Object data){
        Result result=new Result(REnum.SUCCESS);
        result.setData(data);
        return  result;
    }
    public  static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    public  static Result error(Integer code,String msg,Object data){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
    public  static Result error(REnum rEnum){
        Result result=new Result(rEnum);
        return result;
    }
    public  static Result error(REnum rEnum,Object data){
        Result result=new Result(rEnum);
        result.setData(data);
        return result;
    }
    public  static Result success(){

        return success(null);
    }

}
