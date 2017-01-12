package com.dolphin.core.essay;

import com.dolphin.core.BaseService;
import com.dolphin.models.essay.Essay;


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
}
