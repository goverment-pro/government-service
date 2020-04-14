package com.sinosoft.fgw.listmanage.entity;

import java.math.BigDecimal;
import java.util.Date;

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
 * 存储项目表的历史版本记录
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("lm_project_history")
@ApiModel(value="LmProjectHistory对象", description="存储项目表的历史版本记录")
public class LmProjectHistory extends BaseEntity {



    @ApiModelProperty(value = "项目表id")
    @TableField("project_id")
    private Long projectId;

    @ApiModelProperty(value = "所属区域")
    @TableField("area")
    private String area;

    @ApiModelProperty(value = "街乡镇")
    @TableField("street_town")
    private String streetTown;

    @ApiModelProperty(value = "项目分类")
    @TableField("project_type")
    private Integer projectType;

    @ApiModelProperty(value = "支持级别")
    @TableField("support_level")
    private Integer supportLevel;

    @ApiModelProperty(value = "项目类别`")
    @TableField("belong_type")
    private Integer belongType;

    @ApiModelProperty(value = "项目名称")
    @TableField("project_name")
    private String projectName;

    @ApiModelProperty(value = "主管单位")
    @TableField("manage_unit")
    private String manageUnit;

    @ApiModelProperty(value = "建设单位")
    @TableField("construct_unit")
    private String constructUnit;

    @ApiModelProperty(value = "是否立项")
    @TableField("set_up")
    private Integer setUp;

    @ApiModelProperty(value = "基本情况")
    @TableField("basic_situation")
    private String basicSituation;

    @ApiModelProperty(value = "地址类型")
    @TableField("address_type")
    private String addressType;

    @ApiModelProperty(value = "区域")
    @TableField("region")
    private String region;

    @ApiModelProperty(value = "建设地址街乡镇")
    @TableField("constuct_street_town")
    private String constuctStreetTown;

    @ApiModelProperty(value = "具体地址")
    @TableField("detail_address")
    private String detailAddress;

    @ApiModelProperty(value = "占地面积")
    @TableField("property_right_owner")
    private BigDecimal propertyRightOwner;

    @ApiModelProperty(value = "建筑面积")
    @TableField("household_numbers")
    private BigDecimal householdNumbers;

    @ApiModelProperty(value = "现状用地性质")
    @TableField("current_land_property")
    private String currentLandProperty;

    @ApiModelProperty(value = "规划用地性质")
    @TableField("plan_land_property")
    private String planLandProperty;

    @ApiModelProperty(value = "资金来源")
    @TableField("funds_source")
    private String fundsSource;

    @ApiModelProperty(value = "所需资金")
    @TableField("funds_needed")
    private BigDecimal fundsNeeded;

    @ApiModelProperty(value = "项目开始时间")
    @TableField("project_start_date")
    private Date projectStartDate;

    @ApiModelProperty(value = "项目结束时间")
    @TableField("project_finish_date")
    private Date projectFinishDate;

    @ApiModelProperty(value = "是否已提交")
    @TableField("commited")
    private Boolean commited;

    @ApiModelProperty(value = "是否完成")
    @TableField("finished")
    private Boolean finished;

    @ApiModelProperty(value = "版本")
    @TableField("version")
    private Integer version;


}
