/**
 * Copyright (C), 2019-2019,
 * FileName: KafkaApplication
 * Author:   陈腾帅
 * Date:     2019 4 3 0003 16:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 陈腾帅          修改时间           V1.0              描述
 */
package com.example.demo;

import com.example.demo.Kafka.KafkaSender;
import com.example.demo.Kafka.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaApplication {
    @Autowired
    KafkaSender kafkaSender;
    @Autowired
    KafkaConsumer kafkaConsumer;
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }
}