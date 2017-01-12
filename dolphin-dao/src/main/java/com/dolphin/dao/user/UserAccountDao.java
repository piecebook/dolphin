package com.dolphin.dao.user;


import com.dolphin.models.user.UserAccount;

/**
 * 数据库`user_account`表的操作
 * Created on 2016/9/2.
 *
 * @author PieceBook
 * @version 1.0
 */
public interface UserAccountDao {

    /**
     * 插入用户
     *
     * @param user
     */
    void add(UserAccount user);

    /**
     * 通过uid查询用户
     *
     * @param uid 用户uid
     * @return
     */
    UserAccount getByUid(String uid);

    /**
     * 修改用户密码
     *
     * @param user
     */
    void update(UserAccount user);

    /**
     * 通过用户id查询用户
     *
     * @param id 用户id
     * @return
     */
    UserAccount getById(Long id);

}
