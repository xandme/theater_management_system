package com.wyl.tms.model;

public class UserFilmInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_film_info.userFilmInfoId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Integer userFilmInfoId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_film_info.userId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_film_info.filmId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Integer filmId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_film_info.isWant
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Boolean isWant;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_film_info.isWatched
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Boolean isWatched;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_film_info.filmReview
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private String filmReview;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_film_info.filmScore
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    private Double filmScore;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_film_info.userFilmInfoId
     *
     * @return the value of user_film_info.userFilmInfoId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Integer getUserFilmInfoId() {
        return userFilmInfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_film_info.userFilmInfoId
     *
     * @param userFilmInfoId the value for user_film_info.userFilmInfoId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setUserFilmInfoId(Integer userFilmInfoId) {
        this.userFilmInfoId = userFilmInfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_film_info.userId
     *
     * @return the value of user_film_info.userId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_film_info.userId
     *
     * @param userId the value for user_film_info.userId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_film_info.filmId
     *
     * @return the value of user_film_info.filmId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Integer getFilmId() {
        return filmId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_film_info.filmId
     *
     * @param filmId the value for user_film_info.filmId
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_film_info.isWant
     *
     * @return the value of user_film_info.isWant
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Boolean getIsWant() {
        return isWant;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_film_info.isWant
     *
     * @param isWant the value for user_film_info.isWant
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setIsWant(Boolean isWant) {
        this.isWant = isWant;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_film_info.isWatched
     *
     * @return the value of user_film_info.isWatched
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Boolean getIsWatched() {
        return isWatched;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_film_info.isWatched
     *
     * @param isWatched the value for user_film_info.isWatched
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setIsWatched(Boolean isWatched) {
        this.isWatched = isWatched;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_film_info.filmReview
     *
     * @return the value of user_film_info.filmReview
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public String getFilmReview() {
        return filmReview;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_film_info.filmReview
     *
     * @param filmReview the value for user_film_info.filmReview
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setFilmReview(String filmReview) {
        this.filmReview = filmReview == null ? null : filmReview.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_film_info.filmScore
     *
     * @return the value of user_film_info.filmScore
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public Double getFilmScore() {
        return filmScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_film_info.filmScore
     *
     * @param filmScore the value for user_film_info.filmScore
     *
     * @mbg.generated Wed Apr 10 11:04:15 CST 2019
     */
    public void setFilmScore(Double filmScore) {
        this.filmScore = filmScore;
    }
}