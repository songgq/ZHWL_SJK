package com.ustcsoft.jt.service.impl;


import com.ustcsoft.jt.mapper.ShengjkMapper;
import com.ustcsoft.jt.mybatis.Page;
import com.ustcsoft.jt.util.JsonUtil;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;


/**
 * Created by Songgq on 2018/6/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ShengJKListServiceImplTest {

    @After
    public void tearDown() throws Exception {
    }
    @Autowired
    private ShengjkMapper shengjkMapper;
    @Test
    public void getQyxx() {
        System.out.println(11);
        Page<Map> pageVO = Page.buildPageRequest(1, 10);
        List<Map> list =shengjkMapper.getQyxxPage(pageVO);
        System.out.println(JsonUtil.objectToJson(list));

    }
}