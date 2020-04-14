package com.sinosoft.fgw.listmanage.controller;

import com.sinosoft.fgw.listmanage.base.entity.RestfulResponse;
import com.sinosoft.fgw.listmanage.base.enums.MsgEnum;
import com.sinosoft.fgw.listmanage.entity.LmAddress;
import com.sinosoft.fgw.listmanage.service.ILmAddressService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author bj
 * @since 2020-04-08
 */
@RestController
@RequestMapping("/lm-address")
public class LmAddressController {

    @Autowired
    private ILmAddressService lmAddressService;

    @ApiOperation(value = "查询区域乡镇接口", notes = "查询区域乡镇接口")
    @PostMapping("/queryLmAddress")
    public RestfulResponse queryLmAddress(@RequestBody LmAddress lmAddress){
        return RestfulResponse.success(MsgEnum.SUCCESS,lmAddressService.queryLmAddress(lmAddress));
    }

}
