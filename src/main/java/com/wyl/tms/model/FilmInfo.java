package com.wyl.tms.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@TableName("film_info")
public class FilmInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_info.filmId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    @TableId(value = "film_id", type = IdType.AUTO)
    private Integer filmId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_info.filmName
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    @TableField("film_name")
    private String filmName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_info.putOnDate
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @TableField("put_on_date")
    private Date putOnDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_info.putOffDate
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @TableField("put_off_date")
    private Date putOffDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_info.ticketPrice
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    @TableField("ticket_price")
    private Double ticketPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_info.filmType
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    @TableField("film_type")
    private Integer filmType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_info.filmDuration
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    @TableField("film_duration")
    private Integer filmDuration;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_info.director
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private String director;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_info.mainActor
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    @TableField("main_actor")
    private String mainActor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_info.introduction
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private String introduction;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_info.country
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private String country;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_info.language
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private String language;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_info.filmAvgScore
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    @TableField("film_avg_score")
    private Double filmAvgScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_info.filmStatus
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    @TableField("film_status")
    private Boolean filmStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column film_info.isEnabled
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    @TableField("is_enabled")
    private Boolean isEnabled;

    private String url;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column film_info.filmId
     *
     * @return the value of film_info.filmId
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Integer getFilmId() {
        return filmId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column film_info.filmId
     *
     * @param filmId the value for film_info.filmId
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column film_info.filmName
     *
     * @return the value of film_info.filmName
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public String getFilmName() {
        return filmName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column film_info.filmName
     *
     * @param filmName the value for film_info.filmName
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setFilmName(String filmName) {
        this.filmName = filmName == null ? null : filmName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column film_info.putOnDate
     *
     * @return the value of film_info.putOnDate
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Date getPutOnDate() {
        return putOnDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column film_info.putOnDate
     *
     * @param putOnDate the value for film_info.putOnDate
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setPutOnDate(Date putOnDate) {
        this.putOnDate = putOnDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column film_info.putOffDate
     *
     * @return the value of film_info.putOffDate
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Date getPutOffDate() {
        return putOffDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column film_info.putOffDate
     *
     * @param putOffDate the value for film_info.putOffDate
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setPutOffDate(Date putOffDate) {
        this.putOffDate = putOffDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column film_info.ticketPrice
     *
     * @return the value of film_info.ticketPrice
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Double getTicketPrice() {
        return ticketPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column film_info.ticketPrice
     *
     * @param ticketPrice the value for film_info.ticketPrice
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column film_info.filmType
     *
     * @return the value of film_info.filmType
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Integer getFilmType() {
        return filmType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column film_info.filmType
     *
     * @param filmType the value for film_info.filmType
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setFilmType(Integer filmType) {
        this.filmType = filmType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column film_info.filmDuration
     *
     * @return the value of film_info.filmDuration
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Integer getFilmDuration() {
        return filmDuration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column film_info.filmDuration
     *
     * @param filmDuration the value for film_info.filmDuration
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setFilmDuration(Integer filmDuration) {
        this.filmDuration = filmDuration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column film_info.director
     *
     * @return the value of film_info.director
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public String getDirector() {
        return director;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column film_info.director
     *
     * @param director the value for film_info.director
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column film_info.mainActor
     *
     * @return the value of film_info.mainActor
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public String getMainActor() {
        return mainActor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column film_info.mainActor
     *
     * @param mainActor the value for film_info.mainActor
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setMainActor(String mainActor) {
        this.mainActor = mainActor == null ? null : mainActor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column film_info.introduction
     *
     * @return the value of film_info.introduction
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column film_info.introduction
     *
     * @param introduction the value for film_info.introduction
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column film_info.country
     *
     * @return the value of film_info.country
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column film_info.country
     *
     * @param country the value for film_info.country
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column film_info.language
     *
     * @return the value of film_info.language
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public String getLanguage() {
        return language;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column film_info.language
     *
     * @param language the value for film_info.language
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column film_info.filmAvgScore
     *
     * @return the value of film_info.filmAvgScore
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Double getFilmAvgScore() {
        return filmAvgScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column film_info.filmAvgScore
     *
     * @param filmAvgScore the value for film_info.filmAvgScore
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setFilmAvgScore(Double filmAvgScore) {
        this.filmAvgScore = filmAvgScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column film_info.filmStatus
     *
     * @return the value of film_info.filmStatus
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Boolean getFilmStatus() {
        return filmStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column film_info.filmStatus
     *
     * @param filmStatus the value for film_info.filmStatus
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setFilmStatus(Boolean filmStatus) {
        this.filmStatus = filmStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column film_info.isEnabled
     *
     * @return the value of film_info.isEnabled
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column film_info.isEnabled
     *
     * @param isEnabled the value for film_info.isEnabled
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}