package com.example.demo.component;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
public class TimeMetaObjectHandler implements MetaObjectHandler {
    
    @Override
    public void insertFill(MetaObject metaObject) {
        metaObject.setValue("createTime", null);
        metaObject.setValue("updateTime", null);
        this.strictInsertFill(metaObject, "createTime", () -> LocalDateTime.now(), LocalDateTime.class);
        this.strictInsertFill(metaObject, "updateTime", () -> LocalDateTime.now(), LocalDateTime.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        metaObject.setValue("updateTime", null);
        this.strictUpdateFill(metaObject, "updateTime", () -> LocalDateTime.now(), LocalDateTime.class);
    }
}
