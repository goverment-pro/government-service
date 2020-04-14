package com.sinosoft.fgw.listmanage.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sinosoft.fgw.listmanage.entity.LmEvent;
import com.sinosoft.fgw.listmanage.entity.LmProgress;
import com.sinosoft.fgw.listmanage.entity.LmProject;
import com.sinosoft.fgw.listmanage.entity.request.SaveEventProgressRequest;
import com.sinosoft.fgw.listmanage.entity.request.SaveProjectProgressRequest;
import com.sinosoft.fgw.listmanage.enums.EventProgressStateEnum;
import com.sinosoft.fgw.listmanage.enums.RelatedTypeEnum;
import com.sinosoft.fgw.listmanage.mapper.LmEventMapper;
import com.sinosoft.fgw.listmanage.mapper.LmProgressMapper;
import com.sinosoft.fgw.listmanage.mapper.LmProjectMapper;
import com.sinosoft.fgw.listmanage.service.ILmProgressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 事项/项目进展表 服务实现类
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
@Service
@Slf4j
public class LmProgressServiceImpl extends ServiceImpl<LmProgressMapper, LmProgress> implements ILmProgressService {

    @Autowired
    private LmProgressMapper lmProgressMapper;

    @Autowired
    private LmEventMapper lmEventMapper;

    @Autowired
    private LmProjectMapper lmProjectMapper;

    @Override
    public int saveEventProgressInfo(SaveEventProgressRequest request) {
        int num = 0;
        if ("delete".equals(request.getOperationFlag())) {
            num = lmProgressMapper.deleteById(request.getProgressId());
            log.info("删除进展数量：" + num);
        }

        if ("insert".equals(request.getOperationFlag())) {
            if (request.getNewLmProgress() != null && request.getNewLmProgress().size() > 0) {
                for (int i = 0; i < request.getNewLmProgress().size(); i++) {
                    num = lmProgressMapper.insert(request.getNewLmProgress().get(i));
                    log.info("新增进展数量：" + num);
                }
            }
        }

        if("update".equals(request.getOperationFlag())){
            if (request.getNewLmProgress() != null && request.getNewLmProgress().size() > 0) {
                for (int i = 0; i < request.getNewLmProgress().size(); i++) {
                    num = lmProgressMapper.updateById(request.getNewLmProgress().get(i));
                    log.info("编辑进展数量：" + num);
                }
            }
        }
        if (request.getNewLmProgress() != null && request.getNewLmProgress().size() > 0) {
            LmEvent lmEvent = null;
            for (int i = 0; i < request.getNewLmProgress().size(); i++) {
                lmEvent = new LmEvent();
                lmEvent.setId(request.getNewLmProgress().get(i).getRelatedId());
                lmEvent.setCurrentProgressState(request.getNewLmProgress().get(i).getProgressState());
                lmEvent.setCurrentProgressDesc(request.getNewLmProgress().get(i).getProgressDesc());
                int progressNnum = lmEventMapper.updateById(lmEvent);
                log.info("更新事项进展状态数量：" + progressNnum);
            }
        }
        return num;
    }

    @Override
    public List<LmProgress> queryEventProgressHistoryRecord(SaveEventProgressRequest request) {
        List<LmProgress> progressList = lmProgressMapper.selectList(Wrappers.<LmProgress>lambdaQuery().eq(LmProgress::getRelatedId, request.getEventId()).eq(LmProgress::getRelatedType, RelatedTypeEnum.EVENT_PROGRESS).orderByDesc(LmProgress::getCreateDate));
        return progressList;
    }

    @Override
    public int saveProjectProgressInfo(SaveProjectProgressRequest request) {
        int num = 0;
        if ("delete".equals(request.getOperationFlag())) {
            num = lmProgressMapper.deleteById(request.getProgressId());
            log.info("删除进展数量：" + num);
        }

        if ("insert".equals(request.getOperationFlag())) {
            if (request.getNewLmProgress() != null && request.getNewLmProgress().size() > 0) {
                for (int i = 0; i < request.getNewLmProgress().size(); i++) {
                    num = lmProgressMapper.insert(request.getNewLmProgress().get(i));
                    log.info("新增进展数量：" + num);
                }
            }
        }

        if("update".equals(request.getOperationFlag())){
            if (request.getNewLmProgress() != null && request.getNewLmProgress().size() > 0) {
                for (int i = 0; i < request.getNewLmProgress().size(); i++) {
                    num = lmProgressMapper.updateById(request.getNewLmProgress().get(i));
                    log.info("编辑进展数量：" + num);
                }
            }
        }
        if (request.getNewLmProgress() != null && request.getNewLmProgress().size() > 0) {
            LmProject lmProject = null;
            for (int i = 0; i < request.getNewLmProgress().size(); i++) {
                lmProject = new LmProject();
                lmProject.setId(request.getNewLmProgress().get(i).getRelatedId());
                lmProject.setCurrentProgressState(request.getNewLmProgress().get(i).getProgressState());
                lmProject.setCurrentProgressDesc(request.getNewLmProgress().get(i).getProgressDesc());
                int progressNnum = lmProjectMapper.updateById(lmProject);
                log.info("更新项目进展状态数量：" + progressNnum);
            }
        }
        return num;
    }

    @Override
    public List<LmProgress> queryProjectProgressHistoryRecord(SaveProjectProgressRequest request) {
        List<LmProgress> progressList = lmProgressMapper.selectList(Wrappers.<LmProgress>lambdaQuery().eq(LmProgress::getRelatedId, request.getProjectId()).eq(LmProgress::getRelatedType, RelatedTypeEnum.PROJECT_PROGRESS).orderByDesc(LmProgress::getCreateDate));
        return progressList;
    }
}
