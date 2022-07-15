package com.yyds.base;

import org.springframework.ui.Model;

/**
 * @ClassName: BaseController
 * @Author: yyd
 * @Date: 2022/5/23
 * @Description:
 */
public class BaseController {
    private final static String PAGE_SUCCESS = "common/successPage";
    public String successPage(Model model,String successMessage){
        model.addAttribute("messagePage",successMessage);
        return PAGE_SUCCESS;
    }
}
