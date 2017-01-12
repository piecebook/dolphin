package com.dolphin.models.user;

/**
 * 用户账号
 * 用于用户密码验证
 * 一个对象表示数据库表`user_account`一行记录
 * Created on 2016/9/2.
 * @author PieceBook
 * @version 1.0
 */
public class UserAccount {
    /**
     * 用户id，数据库表自增
     */
    private long id;
    /**
     * 用户唯一标识，最长16位。
     */
    private String uid;
    /**
     * 用户密码，最长16位。
     */
    private String password;
    /**
     * 密码后缀，32位。
     */
    private String salt;

    public UserAccount() {
    }

    public UserAccount(String uid, String password, String salt) {
        this.uid = uid;
        this.password = password;
        this.salt = salt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
