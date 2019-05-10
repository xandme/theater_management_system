//package com.wyl.tms.common.aop;
//
//import com.wyl.tms.common.BaseResponse;
//import com.wyl.tms.common.ExtraResponse;
//import org.apache.commons.lang3.StringUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.UUID;
//
//@Aspect
//@Component
//public class AccessRightAspect {
//
//    private Logger logger = LoggerFactory.getLogger(AccessRightAspect.class);
//
//    @Value("${master_key}")
//    private String masterKey;
//
//    @Around(value = "execution(* com.wyl.tms.controller..*.*(..))")
//    public Object accessRightCheck(ProceedingJoinPoint joinPoint) throws Throwable {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String uri = request.getRequestURI();
//        if (uri.startsWith("/order/confirm/seat") ) {
//            String token = request.getHeader("master_key");
//            if (StringUtils.isBlank(token)) {
//                return new BaseResponse(1002, "required token");
//            }
//            if (token.equals(masterKey)) {
//                return joinPoint.proceed();
//            }
//
//            return new BaseResponse(1002, "invalid token");
//        }
//
//        return joinPoint.proceed();
//    }
//
//    /*public static void main(String[] args) {
//        String token = TokenUtil.token(UUID.randomUUID().toString() + "_" + "viroyal");
//        System.out.println(token); //7461c40c82ab15dfb16ef763517fccc4
//    }*/
//}
