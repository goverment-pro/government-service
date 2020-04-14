package com.sinosoft.fgw.listmanage.entity.request;

import com.sinosoft.fgw.listmanage.entity.LmProgress;
import lombok.Data;

import java.util.List;

@Data
public class SaveProjectProgressRequest {

    //修改前进展信息
    List<LmProgress> oldLmProgress;

    //新进展信息
    List<LmProgress> newLmProgress;

    //项目Id
    private Long projectId;

    //操作类型（新增：insert，修改：update，删除：delete）
    private String operationFlag;

    //进展Id
    private  Long progressId;
}
