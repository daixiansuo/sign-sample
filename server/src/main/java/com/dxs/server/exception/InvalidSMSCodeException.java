package com.dxs.server.exception;


import com.dxs.server.enums.ResultCode;

/**
 * @Company: NJBandou
 * @Author: Chen Pan
 * @Description:
 * @Date: 2018/7/5 下午3:32
 */
public class InvalidSMSCodeException extends ApiException{

    public InvalidSMSCodeException() {
        super(ResultCode.INVALID_SMS_CODE.getMsg(), ResultCode.INVALID_SMS_CODE.getCode());
    }
}
