package com.sinosoft.fgw.listmanage.controller;


import com.sinosoft.fgw.listmanage.base.entity.RestfulResponse;
import com.sinosoft.fgw.listmanage.base.enums.MsgEnum;
import com.sinosoft.fgw.listmanage.entity.LmProgress;
import com.sinosoft.fgw.listmanage.entity.request.SaveEventProgressRequest;
import com.sinosoft.fgw.listmanage.entity.request.SaveProjectProgressRequest;
import com.sinosoft.fgw.listmanage.service.ILmModifyRecordService;
import com.sinosoft.fgw.listmanage.service.ILmProgressService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 事项/项目进展表 前端控制器
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
@RestController
@RequestMapping("/lm-progress")
@Slf4j
public class LmProgressController {

    @Autowired
    private ILmProgressService lmProgressService;

    @Autowired
    private ILmModifyRecordService lmModifyRecordService;

    @ApiOperation(value = "保存事项进展信息接口", notes = "保存事项进展信息接口")
    @PostMapping("/saveEventProgressInfo")
    public RestfulResponse saveEventProgressInfo(@RequestBody SaveEventProgressRequest request) {

        Boolean flag = lmModifyRecordService.recordModifyInfo(request);
        log.info("更新记录结果：" + flag);
        int i = lmProgressService.saveEventProgressInfo(request);
        if (1 > 0) {
            return RestfulResponse.success();
        }
        return RestfulResponse.fail();
    }

    @ApiOperation(value = "查询事项进展记录", notes = "查询事项进展记录")
    @PostMapping("/queryEventProgressHistoryRecord")
    public RestfulResponse queryEventProgressHistoryRecord(@RequestBody SaveEventProgressRequest request) {
        List<LmProgress> progressList = lmProgressService.queryEventProgressHistoryRecord(request);
        if (progressList != null && progressList.size() > 0) {
            return RestfulResponse.success(MsgEnum.SUCCESS, progressList);
        }
        return RestfulResponse.fail();
    }

    @ApiOperation(value = "保存项目进展信息接口", notes = "保存项目进展信息接口")
    @PostMapping("/saveProjectProgressInfo")
    public RestfulResponse saveProjectProgressInfo(@RequestBody SaveProjectProgressRequest request) {

        Boolean flag = lmModifyRecordService.recordModifyInfo(request);
        log.info("更新记录结果：" + flag);
        int i = lmProgressService.saveProjectProgressInfo(request);
        if (1 > 0) {
            return RestfulResponse.success();
        }
        return RestfulResponse.fail();
    }

    @ApiOperation(value = "查询项目进展记录", notes = "查询项目进展记录")
    @PostMapping("/queryProjectProgressHistoryRecord")
    public RestfulResponse queryProjectProgressHistoryRecord(@RequestBody SaveProjectProgressRequest request) {
        List<LmProgress> progressList = lmProgressService.queryProjectProgressHistoryRecord(request);
        if (progressList != null && progressList.size() > 0) {
            return RestfulResponse.success(MsgEnum.SUCCESS, progressList);
        }
        return RestfulResponse.fail();
    }


}
