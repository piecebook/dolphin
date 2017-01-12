package com.dolphin.models.essay;

import java.util.Date;

/**
 * 文章
 * 一个对象表示数据库表`essay`一行记录
 * Created on 2016/12/20.
 *
 * @author PieceBook
 * @version 1.0
 * @see Essay
 */
public class Essay_db {
    /**
     * 自增id
     */
    private Long id;
    /**
     * 文章作者id
     */
    private Long author_id;
    /**
     * 文章标题，最长64个字符。
     */
    private String title;
    /**
     * 发表日期
     */
    private Date create_time;
    /**
     * 阅读人数，默认0。
     */
    private Integer view_num;
    /**
     * 点赞人数，默认0。
     */
    private Integer like_num;
    /**
     * 文章正文
     */
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getView_num() {
        return view_num;
    }

    public void setView_num(Integer view_num) {
        this.view_num = view_num;
    }

    public Integer getLike_num() {
        return like_num;
    }

    public void setLike_num(Integer like_num) {
        this.like_num = like_num;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Essay_db{" +
                "id=" + id +
                ", author_id=" + author_id +
                ", title='" + title + '\'' +
                ", create_time=" + create_time +
                ", view_num=" + view_num +
                ", like_num=" + like_num +
                ", text='" + text + '\'' +
                '}';
    }
}
