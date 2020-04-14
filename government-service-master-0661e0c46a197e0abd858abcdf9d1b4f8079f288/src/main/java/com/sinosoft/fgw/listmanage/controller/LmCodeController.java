package com.sinosoft.fgw.listmanage.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sinosoft.fgw.listmanage.base.entity.RestfulResponse;
import com.sinosoft.fgw.listmanage.base.enums.MsgEnum;
import com.sinosoft.fgw.listmanage.entity.LmCode;
import com.sinosoft.fgw.listmanage.entity.LmEvent;
import com.sinosoft.fgw.listmanage.service.ILmCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 码值表 前端控制器
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
@RestController
@RequestMapping("/lm-code")
@Api("码值表操作")
public class LmCodeController {

    @Autowired
    private ILmCodeService lmCodeService;

    @ApiOperation("查询所有码值")
    @PostMapping("queryAll")
    public RestfulResponse<List<LmCode>> queryAllCodes(){
        return RestfulResponse.success(MsgEnum.SUCCESS, lmCodeService.list());
    }

    @ApiOperation("插入码值")
    @PostMapping("save")
    public RestfulResponse<Boolean> queryAllCodes(@RequestBody LmCode lmCode){
        return RestfulResponse.success(MsgEnum.SUCCESS, lmCodeService.save(lmCode));
    }

    @ApiOperation("根据码值类型查询码值")
    @PostMapping("getCodesByCodeTypes")
    public  RestfulResponse<Map<String,List<LmCode>>> getCodesByCodeTypes (@RequestBody List<String> codeType){
        List<LmCode> codes = lmCodeService.list(Wrappers.<LmCode>lambdaQuery().in(LmCode::getCodeType, codeType));
        Map<String, List<LmCode>> result = codes.stream().collect(Collectors.groupingBy(LmCode::getCodeType, Collectors.toList()));
        return RestfulResponse.success(MsgEnum.SUCCESS, result);
    }
}
