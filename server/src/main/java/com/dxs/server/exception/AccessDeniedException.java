package com.dxs.server.exception;


import com.dxs.server.enums.ResultCode;

/**
 * Created by chenpan on 2017/5/25.
 */
public class AccessDeniedException extends ApiException {

    public AccessDeniedException() {
        super(ResultCode.ACCESS_DENIED.getMsg(), ResultCode.ACCESS_DENIED.getCode());
    }

}
