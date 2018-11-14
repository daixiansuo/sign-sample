package com.dxs.server.exception;


import com.dxs.server.enums.ResultCode;

/**
 * Created by chenpan on 2017/5/24.
 */
public class IntegralNotFoundException extends ApiException {

    public IntegralNotFoundException() {
        super(ResultCode.INTEGRAL_NOT_FOUND.getMsg(), ResultCode.INTEGRAL_NOT_FOUND.getCode());
    }

}
