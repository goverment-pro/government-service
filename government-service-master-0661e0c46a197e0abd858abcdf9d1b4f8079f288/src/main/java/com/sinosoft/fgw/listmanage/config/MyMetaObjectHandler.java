package com.sinosoft.fgw.listmanage.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * <p>
 *  数据库自动赋值类
 * </p>
 *
 * @author tongmingjian
 * @since 2020-04-04
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Long userId = 123L;
        this.strictInsertFill(metaObject, "createUser", Long.class, userId);
        this.strictInsertFill(metaObject, "modifyUser", Long.class, userId);
        this.strictInsertFill(metaObject, "createDate", Date.class, new Date());
        this.strictInsertFill(metaObject, "modifyDate", Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Long userId = 456L;
        this.strictUpdateFill(metaObject, "modifyUser", Long.class, userId);
        this.strictUpdateFill(metaObject, "modifyDate", Date.class, new Date());
    }
}