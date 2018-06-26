package com.ustcsoft.jt.controller;

import com.ustcsoft.framework.vo.BaseResult;
import com.ustcsoft.framework.vo.Result;
import com.ustcsoft.jt.constant.Constant;
import com.ustcsoft.jt.exception.AppBusinessException;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author mapp
 * @DES 全局异常处理
 */
@ControllerAdvice
public class GloableExceptionController {


    @ExceptionHandler({AppBusinessException.class})
    @ResponseBody
    public Map<String, Object> businessException(AppBusinessException e) {
        e.printStackTrace();
        if (Constant.SECURITY_ERROR.equals(e.getCode())) {
            return BaseResult.failResult(BaseResult.REQUEST_STATES_AUTHENTICATION_FAILED,
                    StringUtils.isBlank(e.getMessage() ) ?  BaseResult.REQUEST_STATES_AUTHENTICATION_REASON : e.getMessage());
        }else {
            return BaseResult.failResult();
        }

    }

    @ExceptionHandler({Exception.class})
    public Map<String, Object> sqlException(Exception e) {
        e.printStackTrace();
        System.out.println("------------出错了-----------");
        return BaseResult.failResult("服务器异常");
    }
}
