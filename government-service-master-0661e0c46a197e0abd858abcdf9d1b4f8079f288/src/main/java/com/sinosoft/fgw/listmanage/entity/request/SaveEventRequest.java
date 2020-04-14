package com.sinosoft.fgw.listmanage.entity.request;

import com.sinosoft.fgw.listmanage.entity.LmEvent;
import com.sinosoft.fgw.listmanage.entity.LmPosition;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * 事项保存请求实体
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
@Data
public class SaveEventRequest {

    @ApiModelProperty("修改前事项详情")
    private LmEvent oldObj;

    @ApiModelProperty("修改前点位信息")
    private List<LmPosition> oldPositions;

    @ApiModelProperty("修改后事项详情")
    private LmEvent newObj;

    @ApiModelProperty("修改后点位信息")
    private List<LmPosition> newPositions;
}
