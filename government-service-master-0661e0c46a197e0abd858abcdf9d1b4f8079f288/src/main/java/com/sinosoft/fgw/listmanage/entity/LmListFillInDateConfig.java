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
 * 清单填报期限设置表
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("lm_list_fill_in_date_config")
@ApiModel(value="LmListFillInDateConfig对象", description="清单填报期限设置表")
public class LmListFillInDateConfig extends BaseEntity {



    @ApiModelProperty(value = "清单种类")
    @TableField("list_type")
    private Integer listType;

    @ApiModelProperty(value = "支持级别")
    @TableField("support_level")
    private Integer supportLevel;

    @ApiModelProperty(value = "冻结期时间")
    @TableField("freeze_period")
    private String freezePeriod;

    @ApiModelProperty(value = "窗口期时间")
    @TableField("avtive_period")
    private String avtivePeriod;


}
