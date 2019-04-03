/**
 * Copyright (C), 2019-2019,
 * FileName: KafkaConsumer
 * Author:   陈腾帅
 * Date:     2019 4 3 0003 16:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 陈腾帅          修改时间           V1.0              描述
 */
package com.example.demo.Kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
public class KafkaConsumer {

    @Value("${kafka.consumer.topic}")
    private String topic;
    /**
     * 监听topic主题,有消息就读取
     *
     * @param message
     */
    @KafkaListener(topics = {"${kafka.consumer.topic}"})
    public void onMessage(String message) {
        log.info("消费了topic:{},messge:{}", topic, message);
    }
}
