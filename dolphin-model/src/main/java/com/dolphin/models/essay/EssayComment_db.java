package com.dolphin.models.essay;

/**
 * 文章评论
 * 一个对象表示数据库表`essay_comment`一行记录
 * Created on 2016/12/20.
 *
 * @author PieceBook
 * @version 1.0
 */
public class EssayComment_db {
    /**
     * 自增id
     */
    private Long id;
    /**
     * 评论所属文章的id
     */
    private Integer essay_id;
    /**
     * 评论用户的id
     */
    private Long user_id;
    /**
     * 评论用户名
     */
    private String user_name;
    /**
     * 评论用户邮件
     */
    private String user_mail;
    /**
     * 评论正文
     */
    private String text;
    /**
     * 回复该评论的数量
     */
    private Integer apply_num;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEssay_id() {
        return essay_id;
    }

    public void setEssay_id(Integer essay_id) {
        this.essay_id = essay_id;
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

    public Integer getApply_num() {
        return apply_num;
    }

    public void setApply_num(Integer apply_num) {
        this.apply_num = apply_num;
    }
}
