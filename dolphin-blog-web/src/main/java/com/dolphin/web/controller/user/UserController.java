package com.dolphin.web.controller.user;

import com.dolphin.core.BaseService;
import com.dolphin.core.user.UserService;
import com.dolphin.models.user.User_db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户相关请求处理
 * Created on 2017/1/12.
 *
 * @author PieceBook
 * @version 1.0
 */
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/account/register", method = RequestMethod.POST)
    public ModelAndView register(User_db user) {
        Map<String, Object> return_data = new HashMap<String, Object>();
        int code;
        if (reg_dataNull(user)) code = BaseService.DATA_MISSING;
        else if (reg_dataUnPass(user)) code = BaseService.DATA_UNPASS;
        else {
            code = userService.register(user);
        }
        return_data.put("result", code);
        return new ModelAndView("account_register_result", return_data);
    }

    @RequestMapping(value = "/account/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("uid") String uid, @RequestParam("pwd") String pwd) {
        Map<String, Object> return_data = new HashMap<String, Object>();
        int code;
        if (log_dataNull(uid, pwd)) code = BaseService.DATA_MISSING;
        else if (log_dataUnPass(uid, pwd)) code = BaseService.DATA_UNPASS;
        else {
            User_db login_user = new User_db();
            login_user.setUid(uid);
            login_user.setPwd(pwd);
            code = userService.login(login_user);
            login_user.setPwd(null);
            if (code == BaseService.SUCCESS) return_data.put("cur_user", login_user);
        }
        return_data.put("result", code);
        return new ModelAndView("account_login_result", return_data);
    }

    private boolean reg_dataNull(Object data) {
        if (null == data) return true;
        User_db user_info = (User_db) data;
        if (null == user_info.getPwd() || null == user_info.getUser_name() ||
                null == user_info.getUid() || null == user_info.getEmail() || null == user_info.getSex())
            return true;
        else return false;
    }

    private boolean reg_dataUnPass(Object data) {
        User_db user_info = (User_db) data;
        if (user_info.getPwd().length() > 16 || user_info.getEmail().length() > 32
                || user_info.getUid().length() > 16 || user_info.getUser_name().length() > 32)
            return true;
        return false;
    }

    private boolean log_dataNull(String uid, String pwd) {
        if (null == uid || null == pwd) return true;
        return false;
    }

    private boolean log_dataUnPass(String uid, String pwd) {
        if (uid.length() > 16 || pwd.length() > 16) return true;
        return false;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
