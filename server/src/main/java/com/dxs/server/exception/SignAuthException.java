package com.dxs.server.exception;


import com.dxs.server.enums.ResultCode;

/**
 * Created by Mr.Dxs on 2018/10/29.
 */
public class SignAuthException extends ApiException {

    public SignAuthException() {
        super(ResultCode.SIGN_AUTH_NOT_MATCH.getMsg(), ResultCode.SIGN_AUTH_NOT_MATCH.getCode());
    }
}
