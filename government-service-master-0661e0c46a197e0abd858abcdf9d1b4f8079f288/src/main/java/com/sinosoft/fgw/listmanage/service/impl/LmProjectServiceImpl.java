package com.sinosoft.fgw.listmanage.service.impl;

        import com.baomidou.mybatisplus.core.metadata.IPage;
        import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
        import com.sinosoft.fgw.listmanage.entity.LmProject;
        import com.sinosoft.fgw.listmanage.entity.request.QueryEventListRequest;
        import com.sinosoft.fgw.listmanage.entity.request.QueryProjectListRequest;
        import com.sinosoft.fgw.listmanage.entity.response.ProjectClassCountResponse;
        import com.sinosoft.fgw.listmanage.mapper.LmProjectMapper;
        import com.sinosoft.fgw.listmanage.service.ILmProjectService;
        import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

/**
 * <p>
 * 项目表 服务实现类
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
@Service
public class LmProjectServiceImpl extends ServiceImpl<LmProjectMapper, LmProject> implements ILmProjectService {

    @Autowired
    private LmProjectMapper lmProjectMapper;

    @Override
    public ProjectClassCountResponse queryProjectClassCount() {
        return lmProjectMapper.queryProjectClassCount();
    }

    @Override
    public IPage<LmProject> queryProjectList(QueryProjectListRequest request) {
        Page<LmProject> page = new Page<LmProject>(request.getPageNo(), request.getPageSize());
        IPage<LmProject> queryProjectList = lmProjectMapper.queryProjectList(page, request);
        return queryProjectList;
    }
}
