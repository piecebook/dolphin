package com.dolphin.dao.essay;

import com.dolphin.models.essay.Essay;
import com.dolphin.models.essay.Essay_db;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据库表`essay`的操作
 * Created on 2017/1/4.
 *
 * @author PieceBook
 * @version 1.0
 */
public interface EssayDao {
    /**
     * 插入文章
     * view_num 和 like_num 默认 0。
     *
     * @param essay 持久化的文章
     * @return 文章插入数据库后的id
     */
    Long add(Essay_db essay);//TODO confirm:插入失败，但是id依然自增

    /**
     * 分页查询
     *
     * @param offset 数据库表中第一个返回记录的偏移量。offset=0,表示第一行。
     * @param limit  返回记录行的最大数。limit为-1，则表示到最后一行
     * @return 数据库表中第offset-limit行的记录。limit为-1，则返回地offset-last行的记录。
     */
    List<Essay> read(@Param("offset") Long offset, @Param("limit") Integer limit);

    /**
     * 通过id查询文章
     *
     * @param id 文章的id
     * @return
     */
    Essay readById(Long id);

    /**
     * 通过id删除文章
     *
     * @param essay_id 文章id
     */
    void remove(Long essay_id);

    /**
     * 修改文章
     * 只能修改title和text。title和text可以保持不变，但不能为null。
     *
     * @param essay 修改后的文章。t
     */
    void update(Essay_db essay);

    /**
     * 返回文章总数。
     *
     * @return
     */
    //TODO:未实现。
    Long count();
}
