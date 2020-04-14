package com.sinosoft.fgw.listmanage.mapper;

import com.sinosoft.fgw.listmanage.entity.LmProgress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinosoft.fgw.listmanage.entity.request.SaveEventProgressRequest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 事项/项目进展表 Mapper 接口
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
@Component
public interface LmProgressMapper extends BaseMapper<LmProgress> {

    @Delete("DELETE lp FROM lm_progress lp WHERE lp.related_id = #{relatedId}")
    public int deleteEventProgressByRelateId(@Param("relatedId") Long relatedId);
}
