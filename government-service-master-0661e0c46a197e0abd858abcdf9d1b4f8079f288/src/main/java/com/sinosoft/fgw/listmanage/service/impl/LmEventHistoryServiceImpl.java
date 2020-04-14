package com.sinosoft.fgw.listmanage.service.impl;

import com.sinosoft.fgw.listmanage.entity.LmEventHistory;
import com.sinosoft.fgw.listmanage.mapper.LmEventHistoryMapper;
import com.sinosoft.fgw.listmanage.service.ILmEventHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 存储事项表的历史版本记录 服务实现类
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
@Service
public class LmEventHistoryServiceImpl extends ServiceImpl<LmEventHistoryMapper, LmEventHistory> implements ILmEventHistoryService {

}
