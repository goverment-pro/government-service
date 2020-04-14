package com.sinosoft.fgw.listmanage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sinosoft.fgw.listmanage.base.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.sinosoft.fgw.listmanage.enums.RelatedTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 修改记录表
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("lm_event_modify_record")
@ApiModel(value="LmEventModifyRecord对象", description="修改记录表")
public class LmModifyRecord extends BaseEntity {

    @ApiModelProperty(value = "修改类型(事项清单/事项工作进展/项目清单/项目工作进展)")
    @TableField("related_type")
    private RelatedTypeEnum relatedType;

    @ApiModelProperty(value = "关联Id")
    @TableField("related_id")
    private Long relatedId;

    @ApiModelProperty(value = "操作员")
    @TableField("operator")
    private Long operator;

    @ApiModelProperty(value = "版本号")
    @TableField("version")
    private Integer version;

    @ApiModelProperty(value = "内容类型")
    @TableField("content_type")
    private Integer contentType;

    @ApiModelProperty(value = "操作类型")
    @TableField("operate_type")
    private Integer operateType;

    @ApiModelProperty(value = "操作内容")
    @TableField("operate_content")
    private String operateContent;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private Date operateTime;


}
