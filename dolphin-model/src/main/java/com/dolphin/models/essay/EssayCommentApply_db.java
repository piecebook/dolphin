package com.dolphin.models.essay;

/**
 * 评论回复
 * 一个对象表示数据库表`essay_comment_apply`一行记录
 * Created on 2017/1/4.
 *
 * @author PieceBook
 * @version 1.0
 */
public class EssayCommentApply_db {
    /**
     * 自增id
     */
    private Long id;
    /**
     * 该回复所属评论的id
     */
    private Integer comment_id;
    /**
     * 回复用户的id
     */
    private Long user_id;
    /**
     * 回复用户名
     */
    private String user_name;
    /**
     * 回复用户的电子邮件
     */
    private String user_mail;
    /**
     * 回复正文
     */
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
