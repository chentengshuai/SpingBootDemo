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
import com.example.demo.model.RequestModel;
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
        try {
            //kafkaSender.sendTest();
            RequestModel requestModel = new RequestModel();
            //测试登录
            requestModel.setHttpUrl("http://112.35.81.139:18080/sso-web/UspaCsfCrmServlet?servicecode=uspa_IOrgmodelClientCSV_loginIn");
            requestModel.setData("params={\"userCode\":\"ADMIN\",\"passWord\":\"Test@1234\"}");
            requestModel.setContentType("application/x-www-form-urlencoded");
            kafkaSender.topicForPost(requestModel);

//            requestModel.setHttpUrl("http://112.35.44.160:18083/dmp/terminalNorthApi/device-detail?deviceId=" + "57700000637");
//            requestModel.setData("");
//            requestModel.setCookie("td_cookie=1783141882; cnpost=%7B%22username%22%3A%22%E7%AE%A1%E7%90%86%E4%BA%BA%E5%91%98%22%2C%22id%22%3A%22430065424%22%2C%22responseMsg%22%3A%22success%22%2C%22orgId%22%3A%2210006404%22%2C%22orgName%22%3A%22%E4%B8%AD%E5%9B%BD%E7%A7%BB%E5%8A%A8%E6%94%BF%E4%BC%81%E5%88%86%E5%85%AC%E5%8F%B8change%22%2C%22distinctId%22%3A%22100000%22%2C%22distinctTypeId%22%3A%2260%22%2C%22serviceCode%22%3A%22%22%2C%22STAFF_ID%22%3A%224368260%22%2C%22avatar%22%3A%22%22%2C%22success%22%3Atrue%7D; session_id=4028808868fe93a80168fe93a80a185; sign=1004d409d1553f74629c6eec3232767f; JSESSIONID=454F213BCD145D07E8450C209AA2827F");
//            requestModel.topicForGet(rquestModel);

            /////////////测试登录接口//////////


        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

