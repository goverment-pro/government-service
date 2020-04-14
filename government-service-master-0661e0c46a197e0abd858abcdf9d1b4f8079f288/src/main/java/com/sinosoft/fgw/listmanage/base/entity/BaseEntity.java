package com.sinosoft.fgw.listmanage.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 系统数据表默认基类
 * 存储创建/修改的 人/时间
 *
 * @author tongmingjian
 */
@Setter
@Getter
@NoArgsConstructor
public class BaseEntity extends IdEntity {

    //    @JsonIgnore
    @TableField(value = "CREATE_DATE", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建日期")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    //    @JsonIgnore
    @TableField(value = "MODIFY_DATE", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改日期")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyDate;

    @JsonIgnore
    @ApiModelProperty(value = "创建人")
    @TableField(value = "CREATE_USER", fill = FieldFill.INSERT)
    private Long createUser;

    @JsonIgnore
    @ApiModelProperty(value = "修改人")
    @TableField(value = "MODIFY_USER", fill = FieldFill.INSERT_UPDATE)
    private Long modifyUser;

}
