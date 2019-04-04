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

import com.alibaba.fastjson.JSONObject;
import com.example.common.HttpClientUtil;
import com.example.demo.model.RequestHeader;
import com.example.demo.model.RequestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class KafkaConsumer {

    @Value("${kafka.consumer.topic}")
    private String topic;

    @Value("${kafka.consumer.topicForGet}")
    private String topicForGet;

    @Value("${kafka.consumer.topicForPost}")
    private String topicForPost;

    /**
     * 监听topic主题,有消息就读取
     *
     * @param message
     */
    @KafkaListener(topics = {"${kafka.consumer.topic}"})
    public void onMessage(String message) {
        log.info("消费了topic:{},messge:{}", topic, message);
    }

    @KafkaListener(topics = {"${kafka.consumer.topicForGet}"})
    public void onTopicForGet(String message) {
        log.info("消费了topic:{},messge:{}", topicForGet, message);
        JSONObject jsonMessage = JSONObject.parseObject(message);
        String httpUrl = jsonMessage.get("httpUrl").toString();
        String httpData = jsonMessage.get("data").toString();
        String cookie = jsonMessage.get("cookie").toString();
        Map<String, String> headers = new HashMap<>();
        headers.put("Cookie", cookie);
        String result = HttpClientUtil.sendHttpGet(httpUrl, headers);
        log.info(result);
    }


    @KafkaListener(topics = {"${kafka.consumer.topicForPost}"})
    public void onTopicForPost(String message) {
        log.info("消费了topic:{},messge:{}", topicForPost, message);
        RequestModel requestModel = JSONObject.parseObject(message, RequestModel.class);
        Map<String, String> headers = new HashMap<>();
        if (requestModel.getRequestHeaders() != null) {
            for (RequestHeader requestHeade : requestModel.getRequestHeaders()) {
                headers.put(requestHeade.getCode(), requestHeade.getValue());
            }
        }
        String result = "";
        if (requestModel.getContentType().equals("application/x-www-form-urlencoded")) {
            result = HttpClientUtil.sendHttpPost(requestModel.getHttpUrl(), requestModel.getData(), headers);
        }
        if (requestModel.getContentType().equals("application/json;charset=utf-8")) {
            result = HttpClientUtil.sendHttpPostJson(requestModel.getHttpUrl(), requestModel.getData(), headers);
        }
        log.info(result);
    }
}
