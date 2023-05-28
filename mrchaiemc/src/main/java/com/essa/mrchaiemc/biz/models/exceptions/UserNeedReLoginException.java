package com.essa.mrchaiemc.biz.models.exceptions;

public class UserNeedReLoginException extends RuntimeException{
    private final String msg = "need re-login";

    public String getMsg() {
        return msg;
    }
}
