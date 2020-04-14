package com.sinosoft.fgw.listmanage.base.enums;

import com.google.common.collect.ImmutableMap;


/**
 * 默认返回枚举
 *
 * @author tongmingjian
 */
public enum MsgEnum {

    /**
     * 请求成功
     */
    SUCCESS(20000, "请求成功！"),

    /**
     * 权限不足
     */
    AUTH_ERROR(40000, "权限不足！"),

    /**
     * 服务器异常
     */
    SERVER_ERROR(50000, "服务器异常！"),

    /**
     *  事项已存在
     */
    EVENT_ALREADY_EXISTS(50001, "该事项已存在！"),

    /**
     *  项目已存在
     */
    PROJECT_ALREADY_EXISTS(50002, "该项目已存在！"),

    ;
    private final int code;

    private final String message;

    private static final ImmutableMap<Integer, MsgEnum> CACHE;

    static {
        final ImmutableMap.Builder<Integer, MsgEnum> builder = ImmutableMap.builder();
        for (MsgEnum statusCode : values()) {
            builder.put(statusCode.code(), statusCode);
        }
        CACHE = builder.build();
    }

    MsgEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static MsgEnum valueOfCode(int code) {
        final MsgEnum status = CACHE.get(code);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        }
        return status;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }
}