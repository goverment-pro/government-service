package com.sinosoft.fgw.listmanage.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sinosoft.fgw.listmanage.base.entity.BaseEntity;
import com.sinosoft.fgw.listmanage.enums.BelongTypeEnum;
import com.sinosoft.fgw.listmanage.enums.EventSourceEnum;
import com.sinosoft.fgw.listmanage.enums.EventTypeEnum;
import com.sinosoft.fgw.listmanage.enums.SupportLevelEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 存储事项表的历史版本记录
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("lm_event_history")
@ApiModel(value="LmEventHistory对象", description="存储事项表的历史版本记录")
public class LmEventHistory extends BaseEntity {



    @ApiModelProperty(value = "事项表id")
    @TableField("event_id")
    private Long eventId;

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

    @ApiModelProperty(value = "计划完成日期")
    @TableField("plan_finish_date")
    private Date planFinishDate;

    @ApiModelProperty(value = "当前进展状态")
    @TableField("currenet_progress_state")
    private Integer currenetProgressState;

    @ApiModelProperty(value = "当前进展说明")
    @TableField("currenet_progress_desc")
    private String currenetProgressDesc;

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
