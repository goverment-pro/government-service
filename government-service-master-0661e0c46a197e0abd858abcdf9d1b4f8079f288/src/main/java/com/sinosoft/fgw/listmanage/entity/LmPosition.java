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

/**
 * <p>
 * 点位表
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("lm_position")
@ApiModel(value="LmPosition对象", description="点位表")
public class LmPosition extends BaseEntity {



    @ApiModelProperty(value = "点位归属类型(事项清单/项目清单)")
    @TableField("related_type")
    private RelatedTypeEnum relatedType;

    @ApiModelProperty(value = "关联id(事项/项目)")
    @TableField("related_id")
    private Long relatedId;

    @ApiModelProperty(value = "地址类型")
    @TableField("address_type")
    private Integer addressType;

    @ApiModelProperty(value = "详细地址(文字描述)")
    @TableField("detail_address")
    private String detailAddress;

    @ApiModelProperty(value = "点位类型")
    @TableField("position_type")
    private Integer positionType;

    @ApiModelProperty(value = "点位详情(具体点位信息，由前端传入)")
    @TableField("position_detail")
    private String positionDetail;


}
