package com.dxs.server.utils.result;

/**
 *  Created by D丶Cheng on 2018/7/4.
 * @param <T>
 */
public class Result<T> {

    private int code;
    private String msg;
    private T data;

    private Result(){}

    protected Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }


    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }
}
