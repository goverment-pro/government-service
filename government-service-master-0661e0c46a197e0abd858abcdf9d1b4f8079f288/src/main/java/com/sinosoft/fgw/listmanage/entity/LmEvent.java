package com.sinosoft.fgw.listmanage.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.sinosoft.fgw.listmanage.base.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.sinosoft.fgw.listmanage.enums.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 事项表
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("lm_event")
@ApiModel(value="LmEvent对象", description="事项表")
public class LmEvent extends BaseEntity {

    @ApiModelProperty(value = "区域")
    @TableField("area")
    private String area;

    @ApiModelProperty(value = "街乡镇")
    @TableField("street_town")
    private String streetTown;

    @ApiModelProperty(value = "事项类型")
    @TableField("event_type")
    private EventTypeEnum eventType;

    @ApiModelProperty(value = "所属类别")
    @TableField("belong_type")
    private BelongTypeEnum belongType;

    @ApiModelProperty(value = "支持级别")
    @TableField("support_level")
    private SupportLevelEnum supportLevel;

    @ApiModelProperty(value = "事项描述")
    @TableField("event_desc")
    private String eventDesc;

    @ApiModelProperty(value = "事项来源")
    @TableField("event_source")
    private EventSourceEnum eventSource;

    @ApiModelProperty(value = "工单编号")
    @TableField("work_order_no")
    private String workOrderNo;

    @ApiModelProperty(value = "存在问题及原因")
    @TableField("exist_problem")
    private String existProblem;

    @ApiModelProperty(value = "协调事项")
    @TableField("things_to_coordinate")
    private String thingsToCoordinate;

    @ApiModelProperty(value = "研究解决意见")
    @TableField("research_solution")
    private String researchSolution;

    @ApiModelProperty(value = "牵头部门")
    @TableField("department_take_lead")
    private String departmentTakeLead;

    @ApiModelProperty(value = "配合部门")
    @TableField("department_cooperate")
    private String departmentCooperate;

    @ApiModelProperty(value = "涉及企业")
    @TableField("company_involved")
    private String companyInvolved;

    @ApiModelProperty(value = "物业管理单位")
    @TableField("realty_management_agency")
    private String realtyManagementAgency;

    @ApiModelProperty(value = "产权单位")
    @TableField("property_right_owner")
    private String propertyRightOwner;

    @ApiModelProperty(value = "户数")
    @TableField("household_numbers")
    private Integer householdNumbers;

    @ApiModelProperty(value = "面积")
    @TableField("area_size")
    private BigDecimal areaSize;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "计划完成日期")
    @TableField("plan_finish_date")
    private Date planFinishDate;

    @ApiModelProperty(value = "当前进展状态")
    @TableField("current_progress_state")
    private EventProgressStateEnum currentProgressState;

    @ApiModelProperty(value = "当前进展说明")
    @TableField("current_progress_desc")
    private String currentProgressDesc;

    @ApiModelProperty(value = "是否已提交")
    @TableField("commited")
    @JsonProperty(defaultValue = "null")
    private Boolean commited;

    @ApiModelProperty(value = "是否完成")
    @TableField("finished")
    private FinishStateEnum finished;

    @ApiModelProperty(value = "版本")
    @TableField("version")
    private Integer version;

    @ApiModelProperty(value = "逻辑删除字段")
    @TableField("flag")
    private Boolean flag;

    @TableField(exist = false)
    @ApiModelProperty(value = "地址类型，非实体类字段")
    private String addressType;

    @TableField(exist = false)
    @ApiModelProperty(value = "详细地址，非实体类字段")
    private String detailAddress;

    @TableField(exist = false)
    @ApiModelProperty(value = "填报时间，非实体类字段")
    private String fillInTime;

    @TableField(exist = false)
    @ApiModelProperty(value = "点位数量，非实体类字段")
    private String positionCount;

}
