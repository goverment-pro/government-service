package com.sinosoft.fgw.listmanage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.fgw.listmanage.base.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.sinosoft.fgw.listmanage.enums.EventProgressStateEnum;
import com.sinosoft.fgw.listmanage.enums.RelatedTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 事项/项目进展表
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("lm_progress")
@ApiModel(value="LmProgress对象", description="事项/项目进展表")
public class LmProgress extends BaseEntity {



    @ApiModelProperty(value = "进展类型(事项event/项目project)")
    @TableField("related_type")
    private RelatedTypeEnum relatedType;

    @ApiModelProperty(value = "关联事项/项目id")
    @TableField("related_id")
    private Long relatedId;

    @ApiModelProperty(value = "进展状态")
    @TableField("progress_state")
    private EventProgressStateEnum progressState;

    @ApiModelProperty(value = "进展说明")
    @TableField("progress_desc")
    private String progressDesc;

    @ApiModelProperty(value = "附件")
    @TableField("enclosure")
    private String enclosure;

    @JsonFormat(locale = "zh",timezone ="GMT+8",pattern="yyyy-MM-dd HH:mm:ss" )
    @ApiModelProperty(value = "进展填写日期")
    @TableField("progress_wirte_date")
    private Date progressWirteDate;

    @ApiModelProperty(value = "是否删除")
    @TableField("deleted")
    private Boolean deleted;

    @ApiModelProperty(value = "删除原因")
    @TableField("delete_reason")
    private String deleteReason;


}
