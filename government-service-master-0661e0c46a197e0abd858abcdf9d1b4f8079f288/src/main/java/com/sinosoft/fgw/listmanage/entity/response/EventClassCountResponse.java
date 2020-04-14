package com.sinosoft.fgw.listmanage.entity.response;

import lombok.Data;

@Data
public class EventClassCountResponse {

    //事项总数量
    private int totalCount;

    //协调类总数量
    private int coordinateClassCount;

    //政策类总数量
    private int policyClassCount;

    //项目类总数量
    private int projectClassCount;

    //其他类总数量
    private int otherClassCount;

    //市级
    private int cityLevelCount;

    //区级
    private int districtLevelCount;

    //街乡镇级总数量
    private int streetTownLevelCount;

}
