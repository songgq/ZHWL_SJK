package com.ustcsoft.jt.exception;

/**
 * @des app 接口业务异常
 * @author mapp
 * @date 2018/3/21.
 */
public class AppBusinessException extends RuntimeException {


    private String code;

    private String message;

    public AppBusinessException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
