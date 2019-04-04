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

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Kafka.KafkaSender;
import com.example.demo.model.RequestHeader;
import com.example.demo.model.RequestModel;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

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
        try {
            //kafkaSender.sendTest();
            RequestModel requestModelLogin = new RequestModel();
            //测试登录////////////////////////////////////////////
            requestModelLogin.setHttpUrl("http://112.35.81.139:18080/sso-web/UspaCsfCrmServlet?servicecode=uspa_IOrgmodelClientCSV_loginIn");
            requestModelLogin.setData("params={\"userCode\":\"ADMIN\",\"passWord\":\"Test@1234\"}");
            requestModelLogin.setContentType("application/x-www-form-urlencoded");
            kafkaSender.topicForPost(requestModelLogin);
            //测试设备注册////////////////////////////////////////////
            RequestModel requestModelRegister = new RequestModel();
            Map dataReg = new HashMap<String, String>();
            //dataReg.put("Timestamp", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(new Date())); //请求的时间戳
            dataReg.put("deviceName", "wangltpostmanadd");
            dataReg.put("productId", "57700000637");
            dataReg.put("terminalSN", "122100010014");
            dataReg.put("remarks", "004");
            dataReg.put("msisdn", "");
            dataReg.put("customerId", "wangliangtao_test");
            requestModelRegister.setHttpUrl("http://112.35.81.139:18080/dmp/terminalNorthApi/device");
            List<RequestHeader> requestHeaders = new ArrayList<>();
            requestHeaders.add(new RequestHeader("Cookie","td_cookie=1783141882; cnpost=%7B%22username%22%3A%22%E7%AE%A1%E7%90%86%E4%BA%BA%E5%91%98%22%2C%22id%22%3A%22430065424%22%2C%22responseMsg%22%3A%22success%22%2C%22orgId%22%3A%2210006404%22%2C%22orgName%22%3A%22%E4%B8%AD%E5%9B%BD%E7%A7%BB%E5%8A%A8%E6%94%BF%E4%BC%81%E5%88%86%E5%85%AC%E5%8F%B8change%22%2C%22distinctId%22%3A%22100000%22%2C%22distinctTypeId%22%3A%2260%22%2C%22serviceCode%22%3A%22%22%2C%22STAFF_ID%22%3A%224368260%22%2C%22avatar%22%3A%22%22%2C%22success%22%3Atrue%7D; session_id=4028808868fe93a80168fe93a80a186; sign=0611cd06d215a89a9013f11479d85a62; JSESSIONID=299DA70073A4B6575B0C4B1D25833C11"));
            requestModelRegister.setRequestHeaders(requestHeaders);
            requestModelRegister.setContentType("application/json;charset=utf-8");
            requestModelRegister.setData(JSONObject.toJSONString(dataReg));
            kafkaSender.topicForPost(requestModelRegister);


        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

