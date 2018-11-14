package com.dxs.server.exception;

/**
 * 自定义异常
 */
public class ApiException extends RuntimeException {

    private String errMsg;
    private int errCode = 1;

    public ApiException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }

    public ApiException(String errMsg, Throwable e) {
        super(errMsg, e);
        this.errMsg = errMsg;
    }

    public ApiException(int errCode, String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public ApiException(String errMsg, int errCode) {
        super(errMsg);
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public ApiException(String errMsg, int errCode, Throwable e) {
        super(errMsg, e);
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
