package com.sinosoft.fgw.listmanage.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p>
 *    项目类型枚举
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
public enum ProjectTypeEnum {
    /**
     * 市郊铁路类
     */
    SJTL(1),
    /**
     * 道路类
     */
    DL(2),
    /**
     * 园林绿化类
     */
    YLLH(3),
    /**
     * 电力改造类
     */
    DLGZ(4),
    /**
     * 供水改造类
     */
    GSGZ(5),
    /**
     * 污水改造类
     */
    WSGZ(6),
    /**
     * 教育类
     */
    JY(7),
    /**
     * 医疗类
     */
    YL(8),
    /**
     * 老旧小区改造类
     */
    LJXQGZ(9),
    /**
     * 环境提升类
     */
    HJTS(10),
    /**
     * “留白增绿”项目
     */
    LBZLXM(11),
    /**
     * 社区办公活动用房
     */
    SQBGHDYF(12),
    /**
     * 基础设施建设类
     */
    JCSSJS(13),
    /**
     * 公共服务类
     */
    GGFW(14),
    /**
     * 危改拆迁棚改类
     */
    WGCQPGL(15),
    /**
     * 健走步道项目
     */
    JZBDXM(16),
    /**
     * 体育局专项
     */
    TYJZX(17),
    /**
     * 城管委专项
     */
    CGWZX(18),
    /**
     * 污水治理类
     */
    WSZL(19),
    /**
     * 物业管理类
     */
    WYGL(20),
    /**
     * 公共卫生服务设施
     */
    GGWSFUSS(21),
    /**
     * 排水改造类
     */
    PSGZ(22),
    /**
     * 综合整治类
     */
    ZHZZ(23),
    /**
     * 疏整促提升项目
     */
    SZCTSXM(24),
    /**
     * 背街小巷整治
     */
    BJXXZZ(25),
    /**
     * 停车秩序类
     */
    TCZX(26),
    /**
     * 电气改造类
     */
    DQGZ(27),
    /**
     * 燃气管线改造
     */
    RQGXGZ(28),
    /**
     * 其它类
     */
    QT(29),;


    @EnumValue
    @JsonValue
    private final int code;

    ProjectTypeEnum(Integer code){
        this.code = code;
    }

}
