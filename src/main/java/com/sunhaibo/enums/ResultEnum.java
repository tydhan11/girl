package com.sunhaibo.enums;

public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "小学僧"),
    MIDDLE_SCHOOL(101, "你可能上初中"),
    NULL_POINT(-2,"空指针"),
    ARITHMETIC(-3,"算术异常"),
    CLASS_CAST(-4,"类型强制转换异常"),
    NEGATIVE_ARRAY(-5,"数组负下标异常"),
    ARRAY_INDEX_OUT_OF_BOUNDS(-6,"数组下标越界异常"),

    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
