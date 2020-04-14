package com.sinosoft.fgw.listmanage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sinosoft.fgw.listmanage.base.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.sinosoft.fgw.listmanage.base.entity.IdEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author bj
 * @since 2020-04-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("lm_address")
@ApiModel(value="LmAddress对象", description="")
public class LmAddress extends IdEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "01：区域，02：街乡镇")
    @TableField("place_type")
    private String placeType;

    @ApiModelProperty(value = "区域/街乡镇编码")
    @TableField("place_code")
    private String placeCode;

    @ApiModelProperty(value = "汉字名称")
    @TableField("place_name")
    private String placeName;

    @ApiModelProperty(value = "上级编码")
    @TableField("upplace_code")
    private String upplaceCode;

    @ApiModelProperty(value = "地区类别，1,2,3类别，备用字段")
    @TableField("place_category")
    private String placeCategory;

}
