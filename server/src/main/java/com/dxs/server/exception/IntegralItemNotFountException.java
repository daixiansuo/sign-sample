package com.dxs.server.exception;


import com.dxs.server.enums.ResultCode;

/**
 * Created by chenpan on 2017/5/24.
 */
public class IntegralItemNotFountException extends ApiException {

    public IntegralItemNotFountException() {
        super(ResultCode.INTEGRAL_ITEM_NOT_FOUND.getMsg(), ResultCode.INTEGRAL_ITEM_NOT_FOUND.getCode());
    }

}
