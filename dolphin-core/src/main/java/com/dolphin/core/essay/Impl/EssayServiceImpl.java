package com.dolphin.core.essay.Impl;

import com.dolphin.core.essay.EssayService;
import com.dolphin.dao.essay.EssayDao;
import com.dolphin.dao.user.UserDao;
import com.dolphin.models.essay.Essay;
import com.dolphin.models.user.User_db;

import java.util.List;

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
        //if (dataNull(essay)) return DATA_MISSING;
        //if (dataUnPass(essay)) return DATA_UNPASS;
        if (dataConflict(essay)) return DATA_CONFLICT;
        try {
            essayDao.add(essay);
        } catch (Exception e) {
            return SERVER_ERROR;
        }
        return SUCCESS;
    }

    @Override
    public int select(Essay result, Long id) {
        if (null == result) return DATA_MISSING;
        try {
            Essay search_result = essayDao.readById(id);
            if (null == search_result) return FAIL;
            else {
                result.copyOf(search_result);
                return SUCCESS;
            }
        } catch (Exception e) {
            return SERVER_ERROR;
        }
    }

    //TODO:result应该赋值失败。confirm！
    @Override
    public int count(Long result) {
        if (null == result) return DATA_MISSING;
        try {
            Long essay_count = essayDao.count();
            if (null == essay_count) return SERVER_ERROR;
            else {
                result = essay_count;
                return SUCCESS;
            }
        } catch (Exception e) {
            return SERVER_ERROR;
        }
    }

    @Override
    public int selectPage(List<Essay> result_list, Long offset, Integer limit) {
        if (null == result_list) return DATA_MISSING;
        try {
            List<Essay> search_results = essayDao.read(offset, limit);
            if (null == search_results) return DATA_CONFLICT;
            else {
                result_list.addAll(search_results);
                return SUCCESS;
            }
        } catch (Exception e) {
            return SERVER_ERROR;
        }
    }

    /*@Override
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
    }*/

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
