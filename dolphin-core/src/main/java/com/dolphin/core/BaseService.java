package com.dolphin.core;


/**
 * 定义业务处理的状态码，和验证函数
 * 所有业务必须继承此接口
 * Created on 2017/1/12.
 *
 * @author PieceBook
 * @version 1.0
 */
public interface BaseService {
    /**
     * 处理流程成功。处理结果也成功。
     */
    int SUCCESS = 20;
    /**
     * 请求提交的数据有缺失
     */
    int DATA_MISSING = 30;
    /**
     * 请求提交的数据不符合要求
     */
    int DATA_UNPASS = 31;
    /**
     * 请求提交的数据跟数据库数据不一致
     */
    int DATA_CONFLICT = 32;
    /**
     * 处理流程成功，处理结果失败。（处理过程没有发生错误。）
     */
    int FAIL = 40;
    /**
     * 服务器内部错误
     */
    int SERVER_ERROR = 50;

    /**
     * 验证请求提交的数据是否有缺失
     *
     * @param data 请求提交的数据
     * @return 数据缺失，返回true。数据完整，返回false。
     *
     */
    //boolean dataNull(Object data);

    /**
     * 验证请求提交的数据是否符合要求
     * @param data 请求提交的数据
     * @return 数据不合要求，返回true。数据符合，返回false。
     */
    //boolean dataUnPass(Object data);

    /**
     * 验证请求提交的数据是否与数据库一致
     *
     * @param data 请求提交的数据
     * @return 数据冲突，返回true。数据一致，返回false。
     */
    boolean dataConflict(Object data);
}
