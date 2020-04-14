package com.sinosoft.fgw.listmanage.entity.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProjectClassCountResponse {

    //总资金
    private BigDecimal totalFunds;

    //治理类资金
    private BigDecimal governClassFunds;

    //微提升类资金
    private BigDecimal slightLiftClassFunds;

    //腾退空间再利用类资金
    private BigDecimal reuseSpaceClassFunds;

}
