package com.sinosoft.fgw.listmanage.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p>
 *      支持级别枚举
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
public enum SupportLevelEnum {
    /**
     * 市级
     */
    CITY(1),
    /**
     * 区级
     */
    DISTRICT(2),
    /**
     * 街乡镇级
     */
    STREET(3);

    @EnumValue
    @JsonValue
    private final int code;

    SupportLevelEnum(Integer code){
        this.code = code;
    }
}
