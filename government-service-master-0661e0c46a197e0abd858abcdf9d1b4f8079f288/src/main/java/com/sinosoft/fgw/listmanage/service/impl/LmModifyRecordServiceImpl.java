package com.sinosoft.fgw.listmanage.service.impl;

import com.sinosoft.fgw.listmanage.entity.LmEvent;
import com.sinosoft.fgw.listmanage.entity.LmEventHistory;
import com.sinosoft.fgw.listmanage.entity.LmModifyRecord;
import com.sinosoft.fgw.listmanage.entity.request.SaveEventRequest;
import com.sinosoft.fgw.listmanage.enums.RelatedTypeEnum;
import com.sinosoft.fgw.listmanage.mapper.LmEventHistoryMapper;
import com.sinosoft.fgw.listmanage.mapper.LmModifyRecordMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.fgw.listmanage.service.ILmModifyRecordService;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * <p>
 * 修改记录表 服务实现类
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-05
 */
@Slf4j
@Service
public class LmModifyRecordServiceImpl extends ServiceImpl<LmModifyRecordMapper, LmModifyRecord> implements ILmModifyRecordService {

    /**
     * 小写a
     */
    private static final char LOWER_CASE_A = 'a';

    /**
     * 小写z
     */
    private static final char LOWER_CASE_Z = 'z';


    @Autowired
    private LmEventHistoryMapper eventHistoryMapper;

    @Override
    public Boolean init(RelatedTypeEnum type, List<Long> ids) {
        return true;
    }

    @Override
    public Boolean recordModifyInfo(Object requestData) {
        // 修改时
        if(requestData instanceof SaveEventRequest) {
            LmEvent newEvent = ((SaveEventRequest) requestData).getNewObj();
            LmEvent oldEvent = ((SaveEventRequest) requestData).getOldObj();
            // 修改前对象存入历史表中
            BeanCopier copier = BeanCopier.create(LmEvent.class, LmEventHistory.class, false);
            LmEventHistory eventHistory = new LmEventHistory();
            copier.copy(oldEvent, eventHistory, null);
            eventHistory.setId(null);
            eventHistory.setEventId(oldEvent.getId());
            eventHistoryMapper.insert(eventHistory);
            // 遍历字段，对比字段，存储修改项
            Class<? extends LmEvent> eventClass = LmEvent.class;
            Field[] declaredFields = eventClass.getDeclaredFields();
            for (Field field : declaredFields) {
                try {
                    Method method = eventClass.getMethod("get" + upperCase(field.getName()));
                    Object newValue = method.invoke(newEvent);
                    Object oldValue = method.invoke(oldEvent);
                    String value = field.getAnnotation(ApiModelProperty.class).value();
                    log.info("{}-{}-{}",newValue, oldValue, value);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public String upperCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= LOWER_CASE_A && ch[0] <= LOWER_CASE_Z) {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }
}
