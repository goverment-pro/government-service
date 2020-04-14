package com.sinosoft.fgw.listmanage.entity.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class QueryProjectListRequest {
    //当前页数
    private int pageNo;

    //当前页面数量
    private int pageSize;

    //填报日期范围起始日期
    @JsonFormat(locale = "zh",timezone ="GMT+8",pattern="yyyy-MM-dd")
    private Date startDate;

    //填报日期范围终止日期
    @JsonFormat(locale = "zh",timezone ="GMT+8",pattern="yyyy-MM-dd")
    private Date endDate;

    //所属区域
    private String area;

    //街乡镇
    private String streetTown;

    //项目分类
    private int projectType;

    //支持级别
    private int supportLevel;

    //项目类别
    private int belongType;

    //资金来源
    private int fundsSource;

    //项目名称
    private int projectName;

    //建设单位
    private String constructUnit;

    //主管单位
    private int manageUnit;

    //填报状态
    private Boolean commited;

    //进展状态
    private int progressState;

    //完成状态
    private Boolean finished;

}
