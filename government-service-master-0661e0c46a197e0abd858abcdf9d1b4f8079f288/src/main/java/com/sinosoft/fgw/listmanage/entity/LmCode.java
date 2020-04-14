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
 * 码值表
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("lm_code")
@ApiModel(value="LmCode对象", description="码值表")
public class LmCode extends BaseEntity {



    @ApiModelProperty(value = "码值类型")
    @TableField("code_type")
    private String codeType;

    @ApiModelProperty(value = "码值类型含义")
    @TableField("code_type_name")
    private String codeTypeName;

    @ApiModelProperty(value = "码值")
    @TableField("code_value")
    private String codeValue;

    @ApiModelProperty(value = "码值释义")
    @TableField("code_name")
    private String codeName;

    @ApiModelProperty(value = "码值描述")
    @TableField("code_desc")
    private String codeDesc;


    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeTypeName() {
        return codeTypeName;
    }

    public void setCodeTypeName(String codeTypeName) {
        this.codeTypeName = codeTypeName;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }
}
