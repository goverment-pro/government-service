package com.sinosoft.fgw.listmanage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sinosoft.fgw.listmanage.base.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 清单版本管理表
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("lm_list_version")
@ApiModel(value="LmListVersion对象", description="清单版本管理表")
public class LmListVersion extends BaseEntity {



    @ApiModelProperty(value = "改动内容")
    @TableField("change_content")
    private String changeContent;

    @ApiModelProperty(value = "版本")
    @TableField("version")
    private Integer version;

    @ApiModelProperty(value = "存储位置")
    @TableField("save_path")
    private String savePath;

    @ApiModelProperty(value = "存储日期")
    @TableField("save_date")
    private Date saveDate;


}
