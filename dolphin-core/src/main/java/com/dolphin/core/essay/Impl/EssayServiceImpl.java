package com.dolphin.core.essay.Impl;

import com.dolphin.core.essay.EssayService;
import com.dolphin.dao.essay.EssayDao;
import com.dolphin.dao.user.UserDao;
import com.dolphin.models.essay.Essay;
import com.dolphin.models.user.User_db;

/**
 * 文章业务处理实现类
 * Created on 2017/1/12.
 *
 * @author PieceBook
 * @version 1.0
 */
public class EssayServiceImpl implements EssayService {
    /**
     * 用户表DAO
     */
    private UserDao userDao;
    /**
     * 文章表DAO
     */
    private EssayDao essayDao;

    public int submit(Essay essay) {
        if (dataNull(essay)) return DATA_MISSING;
        if (dataUnPass(essay)) return DATA_UNPASS;
        if (dataConflict(essay)) return DATA_CONFLICT;
        try {
            essayDao.add(essay);
        } catch (Exception e) {
            return SERVER_ERROR;
        }
        return SUCCESS;
    }

    @Override
    public boolean dataNull(Object data) {
        if (null == data) return true;
        Essay essay = (Essay) data;
        if (null == essay.getAuthor_id() || null == essay.getAuthor_name() || null == essay.getTitle() || null == essay.getText())
            return true;
        else return false;
    }

    @Override
    public boolean dataUnPass(Object data) {
        Essay essay = (Essay) data;
        if (essay.getTitle().length() > 64 || essay.getAuthor_name().length() > 32) return true;
        return false;
    }

    @Override
    public boolean dataConflict(Object data) {
        Essay essay = (Essay) data;
        User_db user = userDao.getById(essay.getAuthor_id());
        if (null == user) return false;
        if (!user.getUser_name().equals(essay.getAuthor_name())) return true;
        return false;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setEssayDao(EssayDao essayDao) {
        this.essayDao = essayDao;
    }
}
