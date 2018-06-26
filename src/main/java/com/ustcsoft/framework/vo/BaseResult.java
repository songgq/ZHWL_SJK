package com.ustcsoft.framework.vo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @des 接口返回结果
 * @author mpp
 * @dete 2018/3/21
 */
public class BaseResult {

    public static final String ACESS_RESULT_NAME = "success";
    public static final String ACESS_FAILURE_CODE_NAME = "errorCode";
    public static final String ACESS_FAILURE_REASON_NAME = "errorReason";

    // 访问状态返回标志 1成功， 0失败
    public static final String ACESS_SUCCESS = "1";
    public static final String ACESS_FAILURE = "0";

    public static final String MESSAGE = "message";

    // ============业务异常错误编码
    public static final String REQUEST_STATES_SERVICE_ERROR = "500";// 服务器内部错误
    // 参数缺少或者未通过验证
    public static final String REQUEST_STATES_AUTHENTICATION_FAILED = "403";// 权限校验错误
    // ============业务异常错误信息
    public static final String REQUEST_STATES_SERVICE_REASON = "访问错误！！";// 服务器内部错误
    // 通常为业务逻辑错误
    public static final String REQUEST_STATES_AUTHENTICATION_REASON = "用户权限认证错误,无法访问该资源！！";

    /**
     * 成功
     * @return
     */
    public static Map<String, Object> successResult() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put(ACESS_RESULT_NAME, ACESS_SUCCESS);
        return result;
    }

    /**
     * 成功
     * @return
     */
    public static Map<String, Object> successResult(String message) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put(ACESS_RESULT_NAME, ACESS_SUCCESS);
        result.put(MESSAGE, message);
        return result;
    }

    /**
     * 失败
     */
    public static Map<String, Object> failResult() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put(ACESS_RESULT_NAME, ACESS_FAILURE);
        result.put(ACESS_FAILURE_CODE_NAME, REQUEST_STATES_SERVICE_ERROR);
        result.put(ACESS_FAILURE_REASON_NAME, REQUEST_STATES_SERVICE_REASON);
        return result;
    }

    public static Map<String, Object> failResult(String errorReason) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put(ACESS_RESULT_NAME, ACESS_FAILURE);
        result.put(ACESS_FAILURE_CODE_NAME, REQUEST_STATES_SERVICE_ERROR);
        result.put(ACESS_FAILURE_REASON_NAME, errorReason);
        return result;
    }

    public static Map<String, Object> failResult(String errorCode, String errorReason) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put(ACESS_RESULT_NAME, ACESS_FAILURE);
        result.put(ACESS_FAILURE_CODE_NAME, errorCode);
        result.put(ACESS_FAILURE_REASON_NAME, errorReason);
        return result;
    }

    /**
     * 认证失败
     */
    public static Map<String, Object> authFialResult() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put(ACESS_RESULT_NAME, ACESS_FAILURE);
        result.put(ACESS_FAILURE_CODE_NAME, REQUEST_STATES_AUTHENTICATION_FAILED);
        result.put(ACESS_FAILURE_REASON_NAME, REQUEST_STATES_AUTHENTICATION_REASON);
        return result;
    }

    public static Map<String, Object> authFailResult(String errorReason) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put(ACESS_RESULT_NAME, ACESS_FAILURE);
        result.put(ACESS_FAILURE_CODE_NAME, REQUEST_STATES_AUTHENTICATION_FAILED);
        result.put(ACESS_FAILURE_REASON_NAME, errorReason);
        return result;
    }
}
