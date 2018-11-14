package com.dxs.server.enums;

/**
 * Created by D丶Cheng on 2018/7/4.
 */
public enum ResultCode {


    SYSTEM_BUSY(-1, "system too busy"),
    SUCCESS(0, "ok"),


    TOKEN_EXPIRE(42001, "token expire"),


    INVALID_PARAM(40002, "invalid param"),


    ACCESS_DENIED(50001, "access denied"),
    INVALID_SMS_CODE(50003, "invalid sms code"),
    INVALID_OPERATING(50004, "invalid operating"),


    UNKNOW_ERROR(100000, "unknown error"),
    METHOD_NOT_ALLOW(100002, "method not allow"),
    MESSAGE_NOT_READABLE(100003, "message not readable"),
    UNSUPPORTED_MEDIA_TYPE(100004, "unsupported media type"),
    PAGE_NOT_FOUND(100005, "page not found"),
    INFO_NOT_FOUND(100006, "info not found"),
    INTEGRAL_DEFICIENCY(100007, "integral deficiency"),
    VOTE_NOT_ALLOW(100008, "vote not allow"),
    REPORT_EXIST(100009, "report exist"),
    ARTICLE_NOT_FOUND(100010, "article not found"),


    USER_NOT_FOUND(200001, "user not found"),
    USER_PASSWORD_NOT_MATCH(200002, "account and password mismatch "),
    ACCOUNT_EXIST(200003, "account already exist"),
    INTEGRAL_NOT_FOUND(200004, "user integral not found"),
    INTEGRAL_ITEM_NOT_FOUND(200005, "integral item not found"),
    USER_FORBIDDEN(200006,"user forbidden"),
    EMAIL_CODE_EXPIRE_OR_MISMATCH(200007,"email code expire or mismatch"),

    SIGN_AUTH_NOT_MATCH(200008,"sign auth not match");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
