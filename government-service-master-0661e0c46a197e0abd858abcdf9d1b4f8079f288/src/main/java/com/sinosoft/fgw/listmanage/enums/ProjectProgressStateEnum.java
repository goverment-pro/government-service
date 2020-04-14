package com.sinosoft.fgw.listmanage.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProjectProgressStateEnum {
    /**
     * 前期论证
     */
    THE_EARLY_STAGE_OF_THE_ARGUMENT(1),

    /**
     * 已入库
     */
    ENTERED_DATABASE(2),

    /**
     * 立项或纳入计划
     */
    PROJECT_APPROVAL_OR_INCORPORATION_INTO_THE_PLAN(3),

    /**
     * 已开工
     */
    HAS_COMMENCED(4),

    /**
     * 已完工
     */
    HAVE_BEEN_COMPLETED(5);

    @EnumValue
    @JsonValue
    private final int code;

    ProjectProgressStateEnum(Integer code){
        this.code = code;
    }
}
