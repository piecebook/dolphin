package com.dolphin.dao.user;

import com.dolphin.models.user.User_db;

/**
 * 数据库中`user`的操作
 * Created on 2017/1/4.
 *
 * @author PieceBook
 * @version 1.0
 */
public interface UserDao {
    /**
     * 插入用户
     *
     * @param user
     * @return 插入用户后在数据库表中的id。
     */
    Long add(User_db user);

    /**
     * 通过id删除用户
     *
     * @param user_id 用户id
     */
    void remove(Long user_id);

    /**
     * 修改用户
     * 只能修改user_name 、Email 和 sex
     *
     * @param user
     */
    void update(User_db user);

    /**
     * 通过用户uid查询用户
     *
     * @param uid 用户uid
     * @return
     */
    User_db getByUid(String uid);

    /**
     * 通过用户id查询用户
     *
     * @param user_id 用户id
     * @return
     */
    User_db getById(Long user_id);
}
