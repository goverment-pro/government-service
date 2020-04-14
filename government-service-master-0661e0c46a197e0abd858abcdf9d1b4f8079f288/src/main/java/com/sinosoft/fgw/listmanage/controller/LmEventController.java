package com.sinosoft.fgw.listmanage.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sinosoft.fgw.listmanage.base.entity.RestfulResponse;
import com.sinosoft.fgw.listmanage.base.enums.MsgEnum;
import com.sinosoft.fgw.listmanage.entity.LmEvent;
import com.sinosoft.fgw.listmanage.entity.LmPosition;
import com.sinosoft.fgw.listmanage.entity.request.QueryEventListRequest;
import com.sinosoft.fgw.listmanage.entity.request.SaveEventRequest;
import com.sinosoft.fgw.listmanage.entity.response.EventClassCountResponse;
import com.sinosoft.fgw.listmanage.entity.response.QueryEventDetailResponse;
import com.sinosoft.fgw.listmanage.enums.FinishStateEnum;
import com.sinosoft.fgw.listmanage.enums.RelatedTypeEnum;
import com.sinosoft.fgw.listmanage.service.ILmEventService;
import com.sinosoft.fgw.listmanage.service.ILmModifyRecordService;
import com.sinosoft.fgw.listmanage.service.ILmPositionService;
import io.swagger.annotations.Api;
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
 * 事项表 前端控制器
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
@RestController
@RequestMapping("/lm-event")
@Api("事项清单")
@Slf4j
public class LmEventController {

    @Autowired
    private ILmEventService eventService;

    @Autowired
    private ILmPositionService positionService;

    @Autowired
    private ILmModifyRecordService modifyRecordService;

    @ApiOperation("查询事项清单详情")
    @PostMapping("queryEventDetail")
    public RestfulResponse<QueryEventDetailResponse> queryEventDetail(Long eventId) {
        QueryEventDetailResponse eventDetail = new QueryEventDetailResponse();
        eventDetail.setEvent(eventService.getById(eventId));
        eventDetail.setPositions(positionService.list(Wrappers.<LmPosition>lambdaQuery()
                .eq(LmPosition::getRelatedType, RelatedTypeEnum.EVENT)
                .eq(LmPosition::getRelatedId, eventId)
        ));
        return RestfulResponse.success(MsgEnum.SUCCESS, eventDetail);
    }

    @ApiOperation("保存事项清单")
    @PostMapping("saveEvent")
    public RestfulResponse saveEvent(@RequestBody SaveEventRequest saveEventRequest) {
        LmEvent newEvent = saveEventRequest.getNewObj();
        LmEvent oldEvent = saveEventRequest.getOldObj();
        boolean add = oldEvent == null;
        // 如果是新增，判断事项是否已存在
        if (add) {
            int existCount = eventService.count(Wrappers.<LmEvent>lambdaQuery()
                    .eq(LmEvent::getArea, newEvent.getArea())
                    .eq(LmEvent::getStreetTown, newEvent.getStreetTown())
                    .eq(LmEvent::getEventDesc, newEvent.getEventDesc())
            );
            /**
             * 如果能查询到，返回已存在
             */
            if (existCount > 0) {
                return RestfulResponse.fail(MsgEnum.EVENT_ALREADY_EXISTS);
            }
        } else {
            // 不是新增，将旧的点位删除
            positionService.remove(Wrappers.<LmPosition>lambdaQuery()
                    .eq(LmPosition::getRelatedType, RelatedTypeEnum.EVENT)
                    .eq(LmPosition::getRelatedId, oldEvent.getId()));
        }
        // 存储事项信息
        eventService.saveOrUpdate(newEvent);
        // 存储点位信息
        List<LmPosition> newPositions = saveEventRequest.getNewPositions();
        if (CollectionUtils.isNotEmpty(newPositions)) {
            newPositions.forEach(lmPosition -> {
                lmPosition.setRelatedType(RelatedTypeEnum.EVENT);
                lmPosition.setRelatedId(newEvent.getId());
            });
            positionService.saveBatch(newPositions);
        }
        // 处理修改记录信息
        if (!add && newEvent.getCommited()) {
            modifyRecordService.recordModifyInfo(saveEventRequest);
        }
        return RestfulResponse.success(MsgEnum.SUCCESS, eventService.save(saveEventRequest.getNewObj()));
    }

    @ApiOperation(value = "查询事项总数量及各类别事项总数量", notes = "查询事项总数量及各类别事项总数量")
    @PostMapping("/queryEventClassCount")
    public RestfulResponse queryEventClassCount() {
        EventClassCountResponse eventCountResult = eventService.queryEventClassCount();
        return RestfulResponse.success(MsgEnum.SUCCESS, eventCountResult);
    }

    @ApiOperation(value = "批量删除事项接口", notes = "批量删除事项接口")
    @PostMapping("/deleteEvent")
    public RestfulResponse deleteEvent(@RequestBody List<Long> idList) {
        return eventService.removeByIds(idList) ? RestfulResponse.success() : RestfulResponse.fail();
    }

    @ApiOperation(value = "批量更新事项提交接口", notes = "批量更新事项提交接口")
    @PostMapping("/updateEventCommited")
    public RestfulResponse updateEventCommited(@RequestBody List<Long> idList) {
        Boolean flag = modifyRecordService.init(RelatedTypeEnum.EVENT, idList);
        log.info("事项更新结果：" + flag);
        return eventService.update(Wrappers.<LmEvent>lambdaUpdate().set(LmEvent::getCommited, true).set(LmEvent::getFinished, FinishStateEnum.IN_PROGRESS).in(LmEvent::getId, idList)) ? RestfulResponse.success() : RestfulResponse.fail();
    }

    @ApiOperation(value = "更新事项完成状态接口", notes = "更新事项完成状态接口")
    @PostMapping("/updateEventFinished")
    public RestfulResponse updateEventFinished(@RequestBody List<Long> id) {
        return eventService.update(Wrappers.<LmEvent>lambdaUpdate().set(LmEvent::getFinished, FinishStateEnum.FINISHED).in(LmEvent::getId, id)) ? RestfulResponse.success() : RestfulResponse.fail();
    }

    @ApiOperation(value = "查询事项列表接口", notes = "查询事项列表接口")
    @PostMapping("/queryEventList")
    public RestfulResponse queryEventList(@RequestBody QueryEventListRequest request) {
        IPage<LmEvent> iPage = eventService.queryEventList(request);
        return RestfulResponse.success(MsgEnum.SUCCESS, iPage);
    }
}
