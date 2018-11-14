package com.dxs.server.exception;


import com.dxs.server.enums.ResultCode;

public class UserPasswordNotMatchException extends ApiException{

    public UserPasswordNotMatchException() {
        super( ResultCode.USER_PASSWORD_NOT_MATCH.getMsg(), ResultCode.USER_PASSWORD_NOT_MATCH.getCode());
    }

}
