package com.sinosoft.fgw.listmanage.mapper;

import com.sinosoft.fgw.listmanage.entity.LmEventHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 存储事项表的历史版本记录 Mapper 接口
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
@Component
public interface LmEventHistoryMapper extends BaseMapper<LmEventHistory> {

}
