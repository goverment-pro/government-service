package com.sinosoft.fgw.listmanage.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p>
 *    事项来源枚举
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
public enum EventSourceEnum {
    /**
     * 主动治理
     */
    ZHU_DONG(1),
    /**
     * 12345诉求
     */
    FROM_12345(2),
    /**
     * 其它类
     */
    OTHER(3);

    @EnumValue
    @JsonValue
    private final int code;

    EventSourceEnum(Integer code){
        this.code = code;
    }
}
