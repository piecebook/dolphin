package com.dolphin.web.controller.essay;

import com.dolphin.core.BaseService;
import com.dolphin.core.essay.EssayService;
import com.dolphin.models.essay.Essay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public static int ESSAY_NUM_A_PAGE = 5;
    /**
     * 文章业务处理实现类
     */
    @Autowired
    private EssayService essayService;

    /**
     * 发表文章
     *
     * @param essay
     * @return
     */
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ModelAndView submit(Essay essay) {
        Map<String, Object> return_data = new HashMap<String, Object>();
        int code = BaseService.SERVER_ERROR;
        if (dataNull(essay)) code = BaseService.DATA_MISSING;
        else if (dataUnPass(essay)) code = BaseService.DATA_UNPASS;
        else {
            code = essayService.submit(essay);
        }
        return_data.put("result", code);
        return new ModelAndView("essay_submit_result", return_data);
    }
    //TODO:select、selectPage没配置requestmapping.essaycontrol都没测试。
    public ModelAndView select(@RequestParam("click_id") Long click_id) {
        Map<String, Object> return_data = new HashMap<String, Object>();
        int code;
        if (null == click_id) code = BaseService.DATA_MISSING;
        else {
            Essay result = new Essay();
            code = essayService.select(result, click_id);
            if (code == BaseService.SUCCESS) return_data.put("essay", result);
        }
        return_data.put("result", code);
        return new ModelAndView("essay_select_result", return_data);

    }

    public ModelAndView selectPage(@RequestParam("cur_page") Long cur_page) {
        Map<String, Object> return_data = new HashMap<String, Object>();
        int code;
        Long total = -1L;
        code = essayService.count(total);
        if (null == cur_page) code = BaseService.DATA_MISSING;
        if (total != -1L) {
            int pages = total.intValue() / ESSAY_NUM_A_PAGE + 1;
            if (v_dataUnpass(cur_page, pages)) code = BaseService.DATA_UNPASS;
            else {
                List<Essay> results = new ArrayList<Essay>();
                code = essayService.selectPage(results, (cur_page - 1L) * ESSAY_NUM_A_PAGE, ESSAY_NUM_A_PAGE);
                if (code == BaseService.SUCCESS) return_data.put("essaylist", results);
            }
            return_data.put("pages", pages);
            return_data.put("total", total);
        }
        return_data.put("result", code);
        return new ModelAndView("essay_selectPage_result", return_data);
    }

    private boolean v_dataUnpass(Long cur_page, int pages) {
        if (cur_page <= 0 || cur_page > pages) return true;
        return false;
    }

    private boolean dataNull(Object data) {
        if (null == data) return true;
        Essay essay = (Essay) data;
        if (null == essay.getAuthor_id() || null == essay.getAuthor_name() || null == essay.getTitle() || null == essay.getText())
            return true;
        else return false;
    }

    private boolean dataUnPass(Object data) {
        Essay essay = (Essay) data;
        if (essay.getTitle().length() > 64 || essay.getAuthor_name().length() > 32) return true;
        return false;
    }

    public void setEssayService(EssayService essayService) {
        this.essayService = essayService;
    }
}
