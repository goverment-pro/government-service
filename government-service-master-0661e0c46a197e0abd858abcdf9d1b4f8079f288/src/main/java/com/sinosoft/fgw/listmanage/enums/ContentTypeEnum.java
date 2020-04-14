package com.sinosoft.fgw.listmanage.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p>
 *    内容类型枚举
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
public enum ContentTypeEnum {
    /**
     * 基本信息
     */
    BASE_INFO(1),
    /**
     * 涉及点位
     */
    RELATE_TO_POSITION(2),
    /**
     * 存在问题
     */
    PROBLEM_EXIST(3),
    /**
     * 解决意见
     */
    RESOLVE_OPINION(4),
    /**
     * 其他信息
     */
    OTHER_INFO(5),
    /**
     * 事项清单
     */
    EVENT_LIST(6);

    @EnumValue
    @JsonValue
    private final int code;

    ContentTypeEnum(Integer code){
        this.code = code;
    }
}
