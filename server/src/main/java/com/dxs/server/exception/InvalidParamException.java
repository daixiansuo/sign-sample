package com.dxs.server.exception;


import com.dxs.server.enums.ResultCode;

/**
 * @Company: NJBandou
 * @Author: Chen Pan
 * @Description:
 * @Date: 2018/7/5 下午2:22
 */
public class InvalidParamException extends ApiException {


    public InvalidParamException() {
        super(ResultCode.INVALID_PARAM.getMsg(), ResultCode.INVALID_PARAM.getCode());
    }
}
