package com.sinosoft.fgw.listmanage.entity.response;

import com.sinosoft.fgw.listmanage.entity.LmEvent;
import com.sinosoft.fgw.listmanage.entity.LmPosition;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * 查询事项详情返回对象
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
@Data
public class QueryEventDetailResponse {

    @ApiModelProperty("事项详情")
    private LmEvent event;

    @ApiModelProperty("点位信息")
    private List<LmPosition> positions;
}
