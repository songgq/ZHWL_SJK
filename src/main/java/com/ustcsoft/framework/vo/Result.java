package com.ustcsoft.framework.vo;

/**
 * @DES 接口返回值
 * @author mapp
 */
public class Result {

    /** 成功或者失败 */
    private boolean success;
    /** 消息 */
    private String message;
    /** 信息 */
    private Object data;

    public Result(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
