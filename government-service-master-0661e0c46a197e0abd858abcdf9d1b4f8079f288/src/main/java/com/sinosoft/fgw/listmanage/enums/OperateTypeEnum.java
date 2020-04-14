package com.sinosoft.fgw.listmanage.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p>
 *    操作类型枚举
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
public enum OperateTypeEnum {
    /**
     * 编辑
     */
    EDIT(1),
    /**
     * 删除
     */
    DELETE(2),
    /**
     * 还原
     */
    REVERT(3);

    @EnumValue
    @JsonValue
    private final int code;

    OperateTypeEnum(Integer code){
        this.code = code;
    }
}
