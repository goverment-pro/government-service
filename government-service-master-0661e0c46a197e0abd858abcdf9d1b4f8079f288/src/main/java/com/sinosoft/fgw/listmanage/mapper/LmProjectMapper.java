package com.sinosoft.fgw.listmanage.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sinosoft.fgw.listmanage.entity.LmProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinosoft.fgw.listmanage.entity.request.QueryProjectListRequest;
import com.sinosoft.fgw.listmanage.entity.response.ProjectClassCountResponse;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 项目表 Mapper 接口
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
@Component
public interface LmProjectMapper extends BaseMapper<LmProject> {

    //查询项目总数量及各类别事项总数量
    public ProjectClassCountResponse queryProjectClassCount();

    //查询项目列表
    public IPage<LmProject> queryProjectList(Page<LmProject> page, QueryProjectListRequest request);

}
