package edu.fjut.bookshop.common;

/**
 * Created by Administrator on 2017/5/23.
 */
public enum ServerCode {
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(2,"NEED_LOGIN"),
    ILLEGAL_ARGUMENTS(3,"ILLEGAL_ARGUMENTS");

    private final int code;
    private final String desc;

    ServerCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
