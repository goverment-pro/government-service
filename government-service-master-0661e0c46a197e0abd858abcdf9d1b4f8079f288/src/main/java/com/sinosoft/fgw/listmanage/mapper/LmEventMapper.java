package com.sinosoft.fgw.listmanage.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sinosoft.fgw.listmanage.entity.LmEvent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinosoft.fgw.listmanage.entity.request.QueryEventListRequest;
import com.sinosoft.fgw.listmanage.entity.response.EventClassCountResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 事项表 Mapper 接口
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
@Component
public interface LmEventMapper extends BaseMapper<LmEvent> {

    //查询事项总数量及各类别事项总数量
    public EventClassCountResponse queryEventClassCount();

    //查询事项列表
//    public List<LmEvent> queryEventList(QueryEventListRequest request);
    public IPage<LmEvent> queryEventList(Page<LmEvent> page, QueryEventListRequest request);

}
