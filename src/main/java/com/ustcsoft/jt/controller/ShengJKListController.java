package com.ustcsoft.jt.controller;

import com.ustcsoft.jt.mybatis.Page;
import com.ustcsoft.jt.service.ShengJKListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 企业信息列表
 */
@Controller
@RequestMapping(value = "/qyxx")
public class ShengJKListController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ShengJKListService shengJKListService;

    /**
     * 收购单据展示list页面
     * @return
     */
    @RequestMapping("/list.do")
    public String purchaselist() {
        logger.info("企业列表--purchaselist.do");
        return "purchaseAndSale/purchaselist";
    }

    /**
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/search.do")
    @ResponseBody
    public Page<Map> search(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "rows", defaultValue = "10") int rows) {

        Page<Map> pages = null;
        try {
            logger.info("企业列表查询--search.do");
            pages = shengJKListService.getQyxx(page, rows);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return pages;
    }


}
