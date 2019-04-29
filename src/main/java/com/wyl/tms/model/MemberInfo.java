package com.wyl.tms.model;

public class MemberInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_info.memberId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Integer memberId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_info.userId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_info.memberTypeId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Boolean memberTypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_info.name
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_info.telephone
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private String telephone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_info.balance
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Double balance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_info.totalRecharge
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Double totalRecharge;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_info.payPassword
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private String payPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member_info.totalSave
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Double totalSave;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member_info.memberId
     *
     * @return the value of member_info.memberId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member_info.memberId
     *
     * @param memberId the value for member_info.memberId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member_info.userId
     *
     * @return the value of member_info.userId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member_info.userId
     *
     * @param userId the value for member_info.userId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member_info.memberTypeId
     *
     * @return the value of member_info.memberTypeId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Boolean getMemberTypeId() {
        return memberTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member_info.memberTypeId
     *
     * @param memberTypeId the value for member_info.memberTypeId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setMemberTypeId(Boolean memberTypeId) {
        this.memberTypeId = memberTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member_info.name
     *
     * @return the value of member_info.name
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member_info.name
     *
     * @param name the value for member_info.name
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member_info.telephone
     *
     * @return the value of member_info.telephone
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member_info.telephone
     *
     * @param telephone the value for member_info.telephone
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member_info.balance
     *
     * @return the value of member_info.balance
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member_info.balance
     *
     * @param balance the value for member_info.balance
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member_info.totalRecharge
     *
     * @return the value of member_info.totalRecharge
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Double getTotalRecharge() {
        return totalRecharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member_info.totalRecharge
     *
     * @param totalRecharge the value for member_info.totalRecharge
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setTotalRecharge(Double totalRecharge) {
        this.totalRecharge = totalRecharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member_info.payPassword
     *
     * @return the value of member_info.payPassword
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public String getPayPassword() {
        return payPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member_info.payPassword
     *
     * @param payPassword the value for member_info.payPassword
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member_info.totalSave
     *
     * @return the value of member_info.totalSave
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Double getTotalSave() {
        return totalSave;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member_info.totalSave
     *
     * @param totalSave the value for member_info.totalSave
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setTotalSave(Double totalSave) {
        this.totalSave = totalSave;
    }
}