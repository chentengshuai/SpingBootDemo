/**
 * Copyright (C), 2019-2019,
 * FileName: Request10086Demo
 * Author:   陈腾帅
 * Date:     2019 3 29 0029 15:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 陈腾帅          修改时间           V1.0              描述
 */
package com.example.demo.Controller;

import com.example.common.HttpClientUtil;
import com.example.common.RequestHttpClient;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import  java.util.Date;
import com.alibaba.fastjson.JSONObject;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Api(value = "API - Request10086Demo", description = "Request10086Demo")
@RestController
public class Request10086Demo {

    /**
     * @Description: 请求10086的测试方法
     * @Param:
     * @return:
     * @Author: 陈腾帅
     * @Date: 2019-03-29
     */
    @RequestMapping(value = "requestIndex", method = RequestMethod.GET)
    public void requestIndex() {
//        RequestHttpClient.requestTo10086("http://112.35.23.155:18083/dmp/terminalNorthApi/device");
//        DeviceRegister deviceRegister = new DeviceRegister();
//        deviceRegister.setCustomerId("wangliangtao_test");
//        deviceRegister.setProductId("57700000637");
//        deviceRegister.setDeviceName("wangltpostmanadd");
//        deviceRegister.setMsisdn("122100010014");
//        deviceRegister.setRemarks("004");
//        deviceRegister.setTerminalSN("");

//        String Signature = "82e1b357ca04ad09ff8cc010b3632969";
//        String Timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(new Date());
//        String AccessKeyId = "4028808868fe93a80168fe93a80a168";
        try {
            Map data = new HashMap<String, String>();
            data.put("customerId", "wangliangtao_test");
            data.put("productId", "57700000637");
            data.put("deviceName", "wangltpostmanadd");
            data.put("terminalSN", "122100010014");
            data.put("remarks", "004");
            data.put("msisdn", "");
            data.put("Signature", "5dc28b6a01c34e463b49c9ec023fe1e3");           //签名结果串
            data.put("Timestamp", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(new Date())); //请求的时间戳
            data.put("AccessKeyId", "4028808668fe95680168fe9568d3166");            //基础平台颁发给用户的访问服务所 用的密钥ID
            //RequestHttpByClient.requestTo10086("http://112.35.81.139:18080/dmp/terminalNorthApi/device", data);
            //Map<String, String> headers = new HashMap<>();
            //headers.put("Content-Type", "application/json");
            JSONObject json = new JSONObject(data);
            String dataStr = json.toJSONString();//转成string格式
            // ResponseEntity<String> entity = RestTemplateUtil.post("http://112.35.81.139:18080/dmp/terminalNorthApi/device", headers, dataStr, String.class);//            //ResponseEntity<String> entity = RestTemplateUtil.get("https://www.cnblogs.com/{id}/p/{pageName}.html", String.class, "jonban", "rest");
//            System.out.println(entity.toString()); //
            Map<String, String> headers1 = new HashMap<>();
            headers1.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            Map data1 = new HashMap<String, String>();
            data1.put("params", "{\"userCode\":\"ADMIN\",\"passWord\":\"Test@1234\"}");
            //String result1 = RequestHttpClient.requestTo10086("http://112.35.81.139:18080/sso-web/UspaCsfCrmServlet?servicecode=uspa_IOrgmodelClientCSV_loginIn", "POST", headers1, data1);
            Map<String, String> headers2 = new HashMap<>();
            headers2.put("Content-Type", "application/json");
            //String result2 = RequestHttpClient.requestTo10086("http://112.35.81.139:18080/dmp/terminalNorthApi/device", "POST", headers2, data);

            String result3 = HttpClientUtil.sendHttpPost("http://112.35.81.139:18080/sso-web/UspaCsfCrmServlet?servicecode=uspa_IOrgmodelClientCSV_loginIn", "params={\"userCode\":\"ADMIN\",\"passWord\":\"Test@1234\"}");
            System.out.println(result3);

            String result4= HttpClientUtil.sendHttpPostJson("http://112.35.81.139:18080/dmp/terminalNorthApi/device", dataStr);
            System.out.println(result4);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
