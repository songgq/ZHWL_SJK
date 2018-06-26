/*
package com.ustcsoft.jt.controller;

import com.alibaba.fastjson.JSON;
import com.ustcsoft.framework.vo.BaseResult;
import com.ustcsoft.jt.util.Base64Util;
import com.ustcsoft.jt.util.DESUtil;
import com.ustcsoft.jt.vo.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.crypto.Des;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

*/
/**
 * @des 接口测试
 * Created by Administrator on 2018/3/20.
 *//*

@Api(value = "test", description = "测试接口")
@RestController
@RequestMapping(value = "/test", produces = "application/json;charset=utf-8")
public class APITestController {

    @ApiOperation(value = "测试GET", notes = "测试GET", httpMethod = "GET", response = Object.class)
    @RequestMapping(value = "/testSuccess", method = RequestMethod.GET)
    public Map<String, Object> testSuccess(@ApiParam(name = "message", value = "信息", required = true) @RequestParam String message) {
        Map<String, Object> result = BaseResult.successResult();
        result.put("message", "message:" + message);
        return result;
    }



    @ApiOperation(value = "测试加密POST", notes = "测试加密POST", httpMethod = "POST", response = Object.class)
    @RequestMapping(value = "/testdecodeData", method = RequestMethod.POST)
    public Map<String, Object> testdecodeData(@ApiParam(name = "studentJson", value = "加密后的学生信息", required = true) @RequestParam String studentJson) throws Exception {

        // 解密入参
        String jieMi = Base64Util.decodeData(studentJson);
        Student s = JSON.parseObject(jieMi, Student.class);
        System.out.println(s);

        Student student = new Student("赵信", "19");

        Map<String, Object> result = BaseResult.successResult();
        result.put("student", student);

        return result;
    }

    @ApiOperation(value = "测试不加密POST", notes = "测试不加密POST", httpMethod = "POST", response = Object.class)
    @RequestMapping(value = "/testList", method = RequestMethod.POST)
    public Map<String, Object> testList(@RequestBody Student student) throws Exception {


        Map<String, Object> result = BaseResult.successResult();
        result.put("student", student);

        return result;
    }
}
*/
