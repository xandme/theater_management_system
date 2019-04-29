package com.wyl.tms.model;

import java.util.Date;

public class CouponInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon_info.couponId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Integer couponId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon_info.couponTypeId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Integer couponTypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon_info.userId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon_info.receiveDate
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Date receiveDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon_info.invalidDate
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Date invalidDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon_info.couponStatus
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Boolean couponStatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon_info.couponId
     *
     * @return the value of coupon_info.couponId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Integer getCouponId() {
        return couponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon_info.couponId
     *
     * @param couponId the value for coupon_info.couponId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon_info.couponTypeId
     *
     * @return the value of coupon_info.couponTypeId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Integer getCouponTypeId() {
        return couponTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon_info.couponTypeId
     *
     * @param couponTypeId the value for coupon_info.couponTypeId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setCouponTypeId(Integer couponTypeId) {
        this.couponTypeId = couponTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon_info.userId
     *
     * @return the value of coupon_info.userId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon_info.userId
     *
     * @param userId the value for coupon_info.userId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon_info.receiveDate
     *
     * @return the value of coupon_info.receiveDate
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Date getReceiveDate() {
        return receiveDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon_info.receiveDate
     *
     * @param receiveDate the value for coupon_info.receiveDate
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon_info.invalidDate
     *
     * @return the value of coupon_info.invalidDate
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Date getInvalidDate() {
        return invalidDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon_info.invalidDate
     *
     * @param invalidDate the value for coupon_info.invalidDate
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setInvalidDate(Date invalidDate) {
        this.invalidDate = invalidDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon_info.couponStatus
     *
     * @return the value of coupon_info.couponStatus
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Boolean getCouponStatus() {
        return couponStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon_info.couponStatus
     *
     * @param couponStatus the value for coupon_info.couponStatus
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setCouponStatus(Boolean couponStatus) {
        this.couponStatus = couponStatus;
    }
}