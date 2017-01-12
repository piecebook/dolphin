package com.dolphin.web.controller.user;

import com.dolphin.core.user.UserService;
import com.dolphin.models.user.User_db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        int code = userService.register(user);
        return_data.put("result", code);
        return new ModelAndView("account_register_result", return_data);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
