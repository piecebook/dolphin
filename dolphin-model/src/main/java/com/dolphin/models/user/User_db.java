package com.dolphin.models.user;

/**
 * 用户信息
 * 一个对象表示数据库表`user`的一行记录
 * Created on 2017/1/4.
 *
 * @author PieceBook
 * @version 1.0
 */
public class User_db {
    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户唯一标识，最长16位。
     */
    private String uid;
    /**
     * 用户名，最长32位。
     */
    private String user_name;
    /**
     * 性别。0表示男，1表示女。
     */
    private Boolean sex;
    /**
     * 电子邮件，最长32位。
     */
    private String email;

    /**
     * 密码，仅用于注册。不保存进数据库。
     *
     * @see UserAccount
     */
    private String pwd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setUser(User_db othor) {
        this.id = othor.getId();
        this.uid = othor.getUid();
        this.user_name = othor.getUser_name();
        this.email = othor.getEmail();
        this.sex = othor.getSex();
    }

    @Override
    public String toString() {
        return "User_db{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", user_name='" + user_name + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                '}';
    }
}
