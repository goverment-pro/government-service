package com.sinosoft.fgw.listmanage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sinosoft.fgw.listmanage.entity.LmEvent;
import com.sinosoft.fgw.listmanage.entity.request.QueryEventListRequest;
import com.sinosoft.fgw.listmanage.entity.response.EventClassCountResponse;
import com.sinosoft.fgw.listmanage.mapper.LmEventMapper;
import com.sinosoft.fgw.listmanage.service.ILmEventService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 事项表 服务实现类
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
@Service
public class LmEventServiceImpl extends ServiceImpl<LmEventMapper, LmEvent> implements ILmEventService {

    @Autowired
    private LmEventMapper lmEventMapper;

    @Override
    public int addEventInfo(LmEvent lmEvent) {
        int i = lmEventMapper.selectCount(
                Wrappers.<LmEvent>lambdaQuery().eq(LmEvent::getArea, lmEvent.getArea()).eq(LmEvent::getStreetTown, lmEvent.getStreetTown()).eq(LmEvent::getEventDesc, lmEvent.getEventDesc()));
        if (i == 0) {
            return lmEventMapper.insert(lmEvent);
        }
        return 0;
    }

    @Override
    public int updateEventInfo(LmEvent lmEvent) {
        int i = lmEventMapper.updateById(lmEvent);
        return i;
    }

    @Override
    public EventClassCountResponse queryEventClassCount() {
        return lmEventMapper.queryEventClassCount();
    }

    @Override
    public IPage<LmEvent> queryEventList(QueryEventListRequest request) {
        Page<LmEvent> page = new Page<>(request.getPageNo(),request.getPageSize());
        IPage<LmEvent> queryEventList = lmEventMapper.queryEventList(page,request);
        return queryEventList;
    }
}
