package com.sinosoft.fgw.listmanage.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p> 主键基类 </p>
 *
 * @author tongmingjian
 * @version 1.0
 * 创建时间： 2020-04-04 22:03
 */
public class IdEntity implements Serializable {


    @TableId(value = "ID",type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="主键")
    @Setter
    private Long id;

    /**
     * 配置主键的转换json的时候转换为String格式，避免Long类型长度过长导致js丢失精度
     * @return String类型的主键值
     */
    @JsonSerialize(using= ToStringSerializer.class)
    public Long getId() {
        return id;
    }
}
