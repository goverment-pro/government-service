package com.sinosoft.fgw.listmanage.service;

import com.sinosoft.fgw.listmanage.entity.LmModifyRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sinosoft.fgw.listmanage.enums.RelatedTypeEnum;

import java.util.List;

/**
 * <p>
 * 修改记录表 服务类
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-06
 */
public interface ILmModifyRecordService extends IService<LmModifyRecord> {

    /**
     * 提交按钮记录V1版本
     * @param type 修改数据类型
     * @param ids 主键集合
     * @return 是否成功
     */
    Boolean  init(RelatedTypeEnum type, List<Long> ids);

    /**
     * 修改记录版本
     * @return 记录是否成功
     */
    Boolean  recordModifyInfo(Object requestData);

}
