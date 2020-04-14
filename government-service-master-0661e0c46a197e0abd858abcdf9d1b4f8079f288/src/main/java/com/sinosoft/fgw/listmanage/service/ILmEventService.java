package com.sinosoft.fgw.listmanage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sinosoft.fgw.listmanage.entity.LmEvent;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sinosoft.fgw.listmanage.entity.request.QueryEventListRequest;
import com.sinosoft.fgw.listmanage.entity.response.EventClassCountResponse;

import java.util.List;

/**
 * <p>
 * 事项表 服务类
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
public interface ILmEventService extends IService<LmEvent> {
    //新增事项
    public int addEventInfo(LmEvent lmEvent);

    //编辑事项
    public int updateEventInfo(LmEvent lmEvent);

    //查询事项总数量及各类别事项总数量
    public EventClassCountResponse queryEventClassCount();

    //查询事项列表
//    public List<LmEvent> queryEventList(QueryEventListRequest request);
    public IPage<LmEvent> queryEventList(QueryEventListRequest request);
}
