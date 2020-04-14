package com.sinosoft.fgw.listmanage.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p>
 *    所属类别枚举
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
public enum BelongTypeEnum {
    /**
     * 协调类
     */
    XIE_TIAO(1),
    /**
     * 政策类
     */
    ZHENG_CE(2),
    /**
     * 项目类
     */
    XIANG_MU(3),
    /**
     * 其它类
     */
    OTHER(4);

    @EnumValue
    @JsonValue
    private final int code;

    BelongTypeEnum(Integer code){
        this.code = code;
    }

}
