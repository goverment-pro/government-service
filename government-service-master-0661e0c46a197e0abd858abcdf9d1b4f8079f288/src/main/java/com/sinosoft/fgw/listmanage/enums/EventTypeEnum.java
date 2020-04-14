package com.sinosoft.fgw.listmanage.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p>
 *    事项类型枚举
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
public enum EventTypeEnum {

    /**
     * 危改棚改拆迁
     */
    WGPGCQ(1),
    /**
     * 基础设施短板
     */
    JCSSDB(2),
    /**
     * 施工和交通噪音扰民
     */
    SGHJTZYRM(3),
    /**
     * 老旧小区改造
     */
    LJXQGZ(4),
    /**
     * 环境治理
     */
    HJZL(5),
    /**
     * 市属国企事项
     */
    SSGQSX(6),
    /**
     * 公共服务设施短板
     */
    GGFWSSDB(7),
    /**
     * 央企铁路及驻京部队事项
     */
    YQTLJZJBDSX(8),
    /**
     * 物业管理
     */
    WYGL(9),
    /**
     * 群租房整治
     */
    QZFZZ(10),
    /**
     * 土地开发遗留问题处理
     */
    TDKFYLWTCL(11),
    /**
     * 基础设施建设
     */
    JCSSJS(12),
    /**
     * 违法建设治理
     */
    WFJSZL(13),
    /**
     * 停车管理
     */
    TCGL(14),
    /**
     * 其他事项
     */
    QTSX(15),;


    @EnumValue
    @JsonValue
    private final int code;

    EventTypeEnum(Integer code){
        this.code = code;
    }

}
