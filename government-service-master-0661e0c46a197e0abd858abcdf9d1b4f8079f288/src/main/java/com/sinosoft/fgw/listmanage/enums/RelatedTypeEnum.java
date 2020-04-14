package com.sinosoft.fgw.listmanage.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p>
 *   关联枚举
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
public enum  RelatedTypeEnum {

    /**
     * 事项清单
     */
    EVENT(1),
    /**
     * 事项清单进展
     */
    EVENT_PROGRESS(2),
    /**
     * 项目清单
     */
    PROJECT(3),
    /**
     * 项目清单进展
     */
    PROJECT_PROGRESS(4),;

    @EnumValue
    @JsonValue
    private final int code;

    RelatedTypeEnum(Integer code){
        this.code = code;
    }
}
