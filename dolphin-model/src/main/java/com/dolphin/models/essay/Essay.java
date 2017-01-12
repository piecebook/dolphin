package com.dolphin.models.essay;

/**
 * 文章
 * 该类有作者名属性
 * Created on 2017/1/4.
 * @author PieceBook
 * @version 1.0
 * @see Essay_db
 */
public class Essay extends Essay_db {
    /**
     * 作者名
     */
    private String author_name;

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    @Override
    public String toString() {
        return "Essay{" +
                "author_name='" + author_name + '\'' +
                "} " + super.toString();
    }
}
