package com.dolphin.core.user.Impl;

import com.dolphin.core.user.UserService;
import com.dolphin.dao.user.UserAccountDao;
import com.dolphin.dao.user.UserDao;
import com.dolphin.models.user.User_db;

/**
 * 用户业务实现类
 * Created on 2017/1/12.
 *
 * @author PieceBook
 * @version 1.0
 */
public class UserServiceImpl implements UserService {
    /**
     * 用户表DAO
     */
    private UserDao userDao;
    /**
     * 用户账号表DAO
     */
    private UserAccountDao userAccountDao;

    public int register(User_db user) {
        if (dataNull(user)) return DATA_MISSING;
        if (dataUnPass(user)) return DATA_UNPASS;
        if (dataConflict(user)) return DATA_CONFLICT;
        try {
            userDao.add(user);
        } catch (Exception e) {
            return SERVER_ERROR;
        }
        return SUCCESS;
    }

    @Override
    public boolean dataNull(Object data) {
        if (null == data) return true;
        User_db user = (User_db) data;
        if (null == user.getUser_name() || null == user.getUid() || null == user.getEmail() || null == user.getSex())
            return true;
        else return false;
    }

    @Override
    public boolean dataUnPass(Object data) {
        User_db user = (User_db) data;
        if (user.getEmail().length() > 32 || user.getUid().length() > 16 || user.getUser_name().length() > 32)
            return true;
        return false;
    }

    @Override
    public boolean dataConflict(Object data) {
        User_db user = (User_db) data;
        User_db exitUid = userDao.getByUid(user.getUid());
        if (null != exitUid) return true;
        return false;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserAccountDao(UserAccountDao userAccountDao) {
        this.userAccountDao = userAccountDao;
    }
}
