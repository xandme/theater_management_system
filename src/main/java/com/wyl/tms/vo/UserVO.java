package com.wyl.tms.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserVO {
    private Integer userId;
    private String nickname;
    private String username;
    private Integer sex;
    private String telephone;
    private String password;
    private String headPhotoUrl;
    private Date birthday;
    private Integer isMember;
    private Integer integral;

    private Security security;

    @Data
    public static class Security{
        private String token;
        private Integer lifetime;

        public Security(String token, int lifetime) {
            this.token = token;
            this.lifetime = lifetime;
        }
    }
}
