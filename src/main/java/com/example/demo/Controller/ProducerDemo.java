/**
 * Copyright (C), 2019-2019,
 * FileName: KafakaIndex
 * Author:   陈腾帅
 * Date:     2019 3 28 0028 17:24
 * Description: 使用kafaka的初例
 * History:
 * <author>          <time>          <version>          <desc>
 * 陈腾帅          修改时间           V1.0              描述
 */
package com.example.demo.Controller;
import java.util.Properties;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
@RestController
@Api(value = "ProducerDemo", description = "")
public class ProducerDemo {

    /**
    * @Description:  使用kafaka生产消息初例
    * @Param:
    * @return:
    * @Author: 陈腾帅
    * @Date: 2019-03-28
    */
    @RequestMapping(value = "HelloKafakaProducer",method = RequestMethod.GET)
    public void HelloKafakaProducer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "127.1.1.1:9092");
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = null;
        try {
            producer = new KafkaProducer<String, String>(properties);
            for (int i = 0; i < 100; i++) {
                String msg = "Message " + i;
                producer.send(new ProducerRecord<String, String>("HelloWorld", msg));
                System.out.println("Sent:" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            producer.close();
        }
    }
}
