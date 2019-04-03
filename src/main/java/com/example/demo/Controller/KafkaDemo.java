/**
 * Copyright (C), 2019-2019,
 * FileName: KafkaDemo
 * Author:   陈腾帅
 * Date:     2019 4 3 0003 18:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 陈腾帅          修改时间           V1.0              描述
 */
package com.example.demo.Controller;

import com.example.demo.Kafka.KafkaSender;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "KafkaDemo", description = "")
public class KafkaDemo {
    @Autowired
    KafkaSender kafkaSender;

    /**
     * @Description: 使用消费者消费消息初例
     * @Param:
     * @return:
     * @Author: 陈腾帅
     * @Date: 2019-03-28
     */
    @RequestMapping(value = "kafkaDemoTest", method = RequestMethod.GET)
    public void kafkaDemoTest() {
        kafkaSender.sendTest();
    }
}

