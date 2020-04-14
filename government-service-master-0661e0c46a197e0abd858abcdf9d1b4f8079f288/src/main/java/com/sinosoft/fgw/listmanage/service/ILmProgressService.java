package com.sinosoft.fgw.listmanage.service;

import com.sinosoft.fgw.listmanage.entity.LmProgress;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sinosoft.fgw.listmanage.entity.request.SaveEventProgressRequest;
import com.sinosoft.fgw.listmanage.entity.request.SaveProjectProgressRequest;

import java.util.List;

/**
 * <p>
 * 事项/项目进展表 服务类
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
public interface ILmProgressService extends IService<LmProgress> {

    //保存事项进展数据
    public int saveEventProgressInfo(SaveEventProgressRequest request);

    //查询事项进展记录
    public List<LmProgress> queryEventProgressHistoryRecord(SaveEventProgressRequest request);

    //保存项目进展数据
    public int saveProjectProgressInfo(SaveProjectProgressRequest request);

    //查询项目进展记录
    public List<LmProgress> queryProjectProgressHistoryRecord(SaveProjectProgressRequest request);

}
