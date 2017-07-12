package com.imooc.enums;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-28
 */
public enum ResultEnum {

    UNKNOWN_ERROR(-1, "未知错误"),

    SUCCESS(0, "成功"),

    LOLY(100, "loly"),

    JK(101, "jk");

    private int code;

    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ResultEnum stateOf(int index) {
        for (ResultEnum resultStateEnum : values()) {
            if (resultStateEnum.getCode() == index) {
                return resultStateEnum;
            }
        }
        return null;
    }

}
