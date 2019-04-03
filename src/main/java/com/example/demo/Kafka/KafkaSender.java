/**
 * Copyright (C), 2019-2019,
 * FileName: KafkaSender
 * Author:   陈腾帅
 * Date:     2019 4 3 0003 16:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 陈腾帅          修改时间           V1.0              描述
 */
package com.example.demo.Kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class KafkaSender {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.consumer.topic}")
    private String topic;
    /**
     * 发送消息到kafka,主题为test
     */
    public void sendTest() {
        String message = "KafkaTemplate.sendTest" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        kafkaTemplate.send(topic, message);
        log.info("生产了topic:{},messge:{}", topic, message);
    }
}
