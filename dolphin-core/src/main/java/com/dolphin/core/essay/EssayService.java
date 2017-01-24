package com.dolphin.core.essay;

import com.dolphin.core.BaseService;
import com.dolphin.models.essay.Essay;

import java.util.List;


/**
 * 处理文章业务
 * Created on 2017/1/12.
 *
 * @author PieceBook
 * @version 1.0
 * @see com.dolphin.core.essay.Impl.EssayServiceImpl
 */
public interface EssayService extends BaseService {
    /**
     * 发布文章业务
     *
     * @param essay 发布的文章
     * @return 业务处理状态码
     */
    int submit(Essay essay);

    /**
     * 根据文章id查询文章。
     *
     * @param result 返回的文章。
     * @param id     查询文章的id
     * @return 业务处理状态码
     */
    int select(Essay result, Long id);

    /**
     * 查询文章总数。
     *
     * @param result 查询结果
     * @return 业务处理状态码
     */
    int count(Long result);

    /**
     * 分页查询
     *
     * @param result_list 查询结果。
     * @param offset      数据库表中第一个返回记录的偏移量。offset=0,表示第一行。
     * @param limit       返回记录行的最大数。limit为-1，则表示到最后一行
     * @return 业务处理状态码
     */
    int selectPage(List<Essay> result_list, Long offset, Integer limit);
}
