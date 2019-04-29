package com.wyl.tms.handle;

import com.wyl.tms.common.Result;
import com.wyl.tms.exception.RException;
import com.wyl.tms.util.ResultUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    public Result handle(Exception e)
    {
        if(e instanceof RException)
        {
            RException re=(RException)e;
            return ResultUtil.error(re.getCode(),re.getMessage());
        }
        return ResultUtil.error(-999,e.getMessage());
    }
}
