package com.essa.mrchaiemc.biz.models.exceptions;

public class SysInitException extends RuntimeException{
    public String getMsg(){
        return "Sysinit fail";
    };
}
