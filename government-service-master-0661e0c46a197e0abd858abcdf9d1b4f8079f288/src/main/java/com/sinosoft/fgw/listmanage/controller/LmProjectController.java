package com.sinosoft.fgw.listmanage.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sinosoft.fgw.listmanage.base.entity.RestfulResponse;
import com.sinosoft.fgw.listmanage.base.enums.MsgEnum;
import com.sinosoft.fgw.listmanage.entity.LmEvent;
import com.sinosoft.fgw.listmanage.entity.LmProject;
import com.sinosoft.fgw.listmanage.entity.request.QueryProjectListRequest;
import com.sinosoft.fgw.listmanage.entity.response.ProjectClassCountResponse;
import com.sinosoft.fgw.listmanage.enums.FinishStateEnum;
import com.sinosoft.fgw.listmanage.enums.ProjectTypeEnum;
import com.sinosoft.fgw.listmanage.enums.RelatedTypeEnum;
import com.sinosoft.fgw.listmanage.service.ILmModifyRecordService;
import com.sinosoft.fgw.listmanage.service.ILmProjectService;
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
 * 项目表 前端控制器
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
@RestController
@RequestMapping("/lm-project")
@Slf4j
public class LmProjectController {

    @Autowired
    private ILmProjectService lmProjectService;

    @Autowired
    private ILmModifyRecordService lmModifyRecordService;

    @ApiOperation(value = "查询项目总资金及各类别项目资金", notes = "查询项目总资金及各类别项目资金")
    @PostMapping("/queryProjectClassCount")
    public RestfulResponse queryProjectClassCount() {
        ProjectClassCountResponse eventCountResult = lmProjectService.queryProjectClassCount();
        return RestfulResponse.success(MsgEnum.SUCCESS, eventCountResult);
    }

    @ApiOperation(value = "批量删除项目接口", notes = "批量删除项目接口")
    @PostMapping("/deleteProject")
    public RestfulResponse deleteProject(@RequestBody List<Long> idList) {
        return lmProjectService.removeByIds(idList) ? RestfulResponse.success() : RestfulResponse.fail();
    }

    @ApiOperation(value = "批量更新项目提交接口", notes = "批量更新项目提交接口")
    @PostMapping("/updateProjectCommited")
    public RestfulResponse updateProjectCommited(@RequestBody List<Long> idList) {
        Boolean flag = lmModifyRecordService.init(RelatedTypeEnum.PROJECT, idList);
        log.info("项目更新结果：" + flag);
        return lmProjectService.update(Wrappers.<LmProject>lambdaUpdate().set(LmProject::getCommited, true).set(LmProject::getFinished, FinishStateEnum.IN_PROGRESS).in(LmProject::getId, idList)) ? RestfulResponse.success() : RestfulResponse.fail();
    }

    @ApiOperation(value = "更新项目完成状态接口", notes = "更新项目完成状态接口")
    @PostMapping("/updateProjectFinished")
    public RestfulResponse updateProjectFinished(@RequestBody List<Long> id) {
        return lmProjectService.update(Wrappers.<LmProject>lambdaUpdate().set(LmProject::getFinished,FinishStateEnum.FINISHED).in(LmProject::getId)) ? RestfulResponse.success() : RestfulResponse.fail();
    }

    @ApiOperation(value = "查询项目列表接口", notes = "查询项目列表接口")
    @PostMapping("/queryProjectList")
    public RestfulResponse queryProjectList(@RequestBody QueryProjectListRequest request) {
        IPage<LmProject> iPage = lmProjectService.queryProjectList(request);
        return RestfulResponse.success(MsgEnum.SUCCESS, iPage);
    }

}
