package com.ideaaedi.boot.config;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.ideaaedi.zoo.diy.feature.auditlog.api.entity.AuditDTO;
import com.ideaaedi.zoo.diy.feature.auditlog.api.spi.AuditLogRecorder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

@Slf4j
@Component
public class DemoAuditLogRecorder implements AuditLogRecorder {
    @Override
    public void record(@Nonnull AuditDTO auditInfo) {
        log.info(
                "发现审计日志：" + JSON.toJSONString(auditInfo, JSONWriter.Feature.NotWriteNumberClassName, JSONWriter.Feature.PrettyFormat)
        );
    }
}
