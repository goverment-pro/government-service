package com.sinosoft.fgw.listmanage.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p>
 *    事项进展状态枚举
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
public enum EventProgressStateEnum {
    /**
     * 基本解决
     */
    NEARLY_RESOLVED(1),
    /**
     * 已有解决方案和时间表
     */
    HAVE_SOLUTION_AND_SCHEDULE(2),
    /**
     * 已有解决方案正加快推进
     */
    HAVE_SOLUTION_AND_NEED_PUSH_ON(3),
    /**
     * 其它类
     */
    OTHER(4);

    @EnumValue
    @JsonValue
    private final int code;

    EventProgressStateEnum(Integer code){
        this.code = code;
    }
}
