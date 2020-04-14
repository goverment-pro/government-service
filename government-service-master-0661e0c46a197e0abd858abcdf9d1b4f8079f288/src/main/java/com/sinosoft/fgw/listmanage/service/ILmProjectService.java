package com.sinosoft.fgw.listmanage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sinosoft.fgw.listmanage.entity.LmProject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sinosoft.fgw.listmanage.entity.request.QueryProjectListRequest;
import com.sinosoft.fgw.listmanage.entity.response.ProjectClassCountResponse;

/**
 * <p>
 * 项目表 服务类
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
public interface ILmProjectService extends IService<LmProject> {

    //查询项目总数量及各类别事项总数量
    public ProjectClassCountResponse queryProjectClassCount();

    //查询项目列表
    public IPage<LmProject> queryProjectList(QueryProjectListRequest request);

}
