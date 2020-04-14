package com.sinosoft.fgw.listmanage.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p>
 *    完成状态枚举枚举
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-07
 */
public enum FinishStateEnum {
    /**
     * 未开始
     */
    NOT_STARTED(1),
    /**
     * 进行中
     */
    IN_PROGRESS(2),
    /**
     * 已完成
     */
    FINISHED(3),;

    @EnumValue
    @JsonValue
    private final int code;

    FinishStateEnum(Integer code){
        this.code = code;
    }
}
