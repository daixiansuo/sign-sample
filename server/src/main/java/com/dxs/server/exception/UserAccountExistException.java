package com.dxs.server.exception;


import com.dxs.server.enums.ResultCode;

public class UserAccountExistException extends ApiException {

    public UserAccountExistException() {
        super(ResultCode.ACCOUNT_EXIST.getMsg(), ResultCode.ACCOUNT_EXIST.getCode());
    }

    public UserAccountExistException(String msg, int code) {
        super(msg, code);
    }

}
