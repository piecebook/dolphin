package com.dolphin.web.controller.essay;

import com.dolphin.core.essay.EssayService;
import com.dolphin.models.essay.Essay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 文章相关请求处理
 * Created on 2017/1/12.
 *
 * @author PieceBook
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/essay")
public class EssayController {
    /**
     * 文章业务处理实现类
     */
    @Autowired
    private EssayService essayService;

    /**
     * 发表文章
     * @param essay
     * @return
     */
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ModelAndView submit(Essay essay) {
        Map<String, Object> return_data = new HashMap<String, Object>();
        int code = essayService.submit(essay);
        return_data.put("result", code);
        return new ModelAndView("essay_submit_result", return_data);
    }

    public void setEssayService(EssayService essayService) {
        this.essayService = essayService;
    }
}
