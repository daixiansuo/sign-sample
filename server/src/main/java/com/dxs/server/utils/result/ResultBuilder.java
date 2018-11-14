package com.dxs.server.utils.result;


import java.util.HashMap;

/**
 * Created by D丶Cheng on 2018/7/4.
 *
 * @param <T>
 */
public class ResultBuilder<T> {

    private int code = 0;

    private String msg = "返回成功";

    private T data;

    public ResultBuilder<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public ResultBuilder<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResultBuilder<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Result<T> build() {
        return new Result<T>(this.code, this.msg, this.data != null ? this.data : (T) new HashMap());
    }

    public Result<T> error(String msg) {
        return new Result<T>(-1, msg, (T) new HashMap());
    }

    public Result<T> success() {
        return new Result<T>(0, "操作成功", (T) new HashMap());
    }

    public Result<T> success(String msg) {
        return new Result<T>(0, msg, (T) new HashMap());
    }

    public Result<T> success(String msg, T data) {
        return new Result<T>(0, msg,
                data != null ? data : (T) new HashMap());
    }
}
