package com.sinosoft.fgw.listmanage.entity.response;

import com.sinosoft.fgw.listmanage.entity.LmCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 码值查询返回实体
 */
@Data
public class GetCodesByTypeResponse {

    @ApiModelProperty("码值类型")
    private String type;

    @ApiModelProperty("码值列表")
    private List<LmCode> codes;
}
