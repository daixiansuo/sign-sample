package com.dxs.server.exception;


import com.dxs.server.enums.ResultCode;

/**
 * Created by chenpan on 2017/5/23.
 */
public class TokenExpireException extends ApiException {


    public TokenExpireException() {
        super(ResultCode.TOKEN_EXPIRE.getMsg(), ResultCode.TOKEN_EXPIRE.getCode());
    }

    public TokenExpireException(String msg, int code) {
        super(msg, code);
    }
}
