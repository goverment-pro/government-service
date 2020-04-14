package com.sinosoft.fgw.listmanage.entity.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class QueryEventListRequest {

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

    //支持级别
    private int supportLevel;

    //所属类别
    private int belongType;

    //事项类型
    private int eventType;

    //地址类型
    private int addressType;

    //牵头部门
    private String departmentTakeLead;

    //事项来源
    private int eventSource;

    //填报状态
    private Boolean commited;

    //当前进展状态
    private int currentProgressState;

    //完成状态
    private Boolean finished;

    //事项描述
    private String eventDesc;

}
