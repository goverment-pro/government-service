package com.sinosoft.fgw.listmanage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sinosoft.fgw.listmanage.base.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("lm_privilege")
@ApiModel(value="LmPrivilege对象", description="权限表")
public class LmPrivilege extends BaseEntity {



    @ApiModelProperty(value = "权限名称")
    @TableField("privilege_name")
    private String privilegeName;

    @ApiModelProperty(value = "权限类型")
    @TableField("privilege_type")
    private String privilegeType;

    @ApiModelProperty(value = "权限地址")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "上级权限id")
    @TableField("pid")
    private Long pid;

    @ApiModelProperty(value = "权限操作类型")
    @TableField("privilege_operate_type")
    private String privilegeOperateType;

    @ApiModelProperty(value = "权限顺序")
    @TableField("privilege_order")
    private String privilegeOrder;


}
