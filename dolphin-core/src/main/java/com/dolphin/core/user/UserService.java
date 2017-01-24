package com.dolphin.core.user;

import com.dolphin.core.BaseService;
import com.dolphin.models.user.User_db;

/**
 * 用户业务处理
 * Created on 2017/1/12.
 *
 * @author PieceBook
 * @version 1.0
 * @see com.dolphin.core.user.Impl.UserServiceImpl
 */
public interface UserService extends BaseService {
    /**
     * 用户注册业务
     *
     * @param user 注册用户的数据
     * @return 业务处理状态码
     */
    int register(User_db user);

    /**
     * 用户登录
     *
     * @param user 用户登录信息
     * @return 业务处理状态码
     */
    int login(User_db user);
}
