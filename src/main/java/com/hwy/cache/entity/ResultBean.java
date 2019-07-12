package com.hwy.cache.entity;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/11 16:02
 */
public class ResultBean {

    private String message;

    private Object data;

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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private int code;

    public static ResultBean SUCCESS = new ResultBean("success", 200);

    public static ResultBean FAILURE = new ResultBean("failure", 400);

    public ResultBean(String message, Object data, int code) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public ResultBean(String message, int code) {
        this.code = code;
        this.message = message;
    }

}
