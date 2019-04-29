package com.wyl.tms.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@RequestMapping("/tms")
@Controller
public class appController {

    @Autowired
    DefaultKaptcha defaultKaptcha;

    @RequestMapping("/index")
    public  String index(){
        return "/home/index";
    }

    @RequestMapping("/market")
    public  String market(){
        return "/market/market";
    }

    @RequestMapping("/personal")
    public  String personal(){
        return "/personal/personal";
    }

    @RequestMapping("/setting")
    public  String setting(){
        return "/personal/setting";
    }

    @RequestMapping("/personInfo")
    public  String personInfo(){
        return "/personal/personInfo";
    }

    @RequestMapping("/member")
    public  String member(){
        return "/personal/member";
    }

    @RequestMapping("/memberDetail")
    public  String memberDetail(){
        return "/personal/memberDetail";
    }

    @RequestMapping("coupon")
    public String coupon() {
        return "/personal/coupon";
    }

    @RequestMapping("/theaterList")
    public  String theaterList(){
        return "/common/theaterList";
    }

    @RequestMapping("/search")
    public String search() {
        return "/common/search";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}



