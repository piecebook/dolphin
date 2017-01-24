package com.dolphin.core.user.Impl;

import com.dolphin.core.user.UserService;
import com.dolphin.core.util.PWD_Util;
import com.dolphin.dao.user.UserAccountDao;
import com.dolphin.dao.user.UserDao;
import com.dolphin.models.user.UserAccount;
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

    public int register(User_db user_info) {
        //if (dataNull(user_info)) return DATA_MISSING;
        //if (dataUnPass(user_info)) return DATA_UNPASS;
        if (dataConflict(user_info)) return DATA_CONFLICT;
        try {
            String salt = PWD_Util.getSalt(32);
            String pwd_hash = PWD_Util.getHash(user_info.getPwd() + salt);
            UserAccount user_account = new UserAccount(user_info.getUid(), pwd_hash, salt);
            userAccountDao.add(user_account);
            user_info.setId(user_account.getId());
            userDao.add(user_info);
        } catch (Exception e) {
            return SERVER_ERROR;
        }
        return SUCCESS;
    }

    @Override
    public int login(User_db login_user) {
        if (!dataConflict(login_user)) return DATA_CONFLICT;
        try {
            UserAccount user_db = userAccountDao.getByUid(login_user.getUid());
            String salt = user_db.getSalt();
            String login_pwd = PWD_Util.getHash(login_user.getPwd() + salt);
            if (login_pwd.equals(user_db.getPassword())) {
                User_db userinfo = userDao.getById(user_db.getId());
                login_user.setUser(userinfo);
                return SUCCESS;
            }
        } catch (Exception e) {
            return SERVER_ERROR;
        }
        return FAIL;
    }

    /*@Override
    public boolean dataNull(Object data) {
        if (null == data) return true;
        User_db user_info = (User_db) data;
        if (null == user_info.getPwd() || null == user_info.getUser_name() ||
                null == user_info.getUid() || null == user_info.getEmail() || null == user_info.getSex())
            return true;
        else return false;
    }

    @Override
    public boolean dataUnPass(Object data) {
        User_db user_info = (User_db) data;
        if (user_info.getPwd().length() > 16 || user_info.getEmail().length() > 32
                || user_info.getUid().length() > 16 || user_info.getUser_name().length() > 32)
            return true;
        return false;
    }*/

    @Override
    public boolean dataConflict(Object data) {
        User_db user_info = (User_db) data;
        UserAccount exitUid = userAccountDao.getByUid(user_info.getUid());
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
