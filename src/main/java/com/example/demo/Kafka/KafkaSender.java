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

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.RequestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class KafkaSender {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.consumer.topic}")
    private String topic;

    @Value("${kafka.consumer.topicForGet}")
    private String topicForGet;


    @Value("${kafka.consumer.topicForPost}")
    private String topicForPost;
    /**
     * 发送消息到kafka,主题为test
     */
    public void sendTest() {
        String message = "KafkaTemplate.sendTest" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        kafkaTemplate.send(topic, message);
        log.info("生产了topic:{},messge:{}", topic, message);
    }

    /**
    * @Description:   发送Get请求
    * @Param: @param RequestModel
    * @return:
    * @Author: 陈腾帅
    * @Date: 2019-04-04
    */
    public void topicForGet(RequestModel requestModel) throws Exception {
        try {
            String message=JSONObject.toJSONString(requestModel);
            kafkaTemplate.send(topicForGet, requestModel.toString());
            log.info("生产了topic:{},messge:{}", topicForGet, message);
        } catch (Exception e) {
            log.info("KafkaSender.topicForGet" + e.toString());
        }
    }

    /**
     * @Description:   发送Get请求
     * @Param: @param RequestModel
     * @return:
     * @Author: 陈腾帅
     * @Date: 2019-04-04
     */
    public void topicForPost(RequestModel requestModel) throws Exception {
        try {
            String message=JSONObject.toJSONString(requestModel);
            kafkaTemplate.send(topicForPost, message);
            log.info("生产了topic:{},messge:{}", topicForPost, message);
        } catch (Exception e) {
            log.info("KafkaSender.topicForGet" + e.toString());
        }
    }
}
