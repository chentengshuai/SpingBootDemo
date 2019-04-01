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

import com.example.common.RequestHttpByClient;
import com.example.common.RequestHttpClient;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        Map<String, String> data = new HashMap<>();
        data.put("customerId", "wangliangtao_test");
        data.put("productId", "57700000637");
        data.put("deviceName", "wangltpostmanadd");
        data.put("terminalSN", "122100010014");
        data.put("remarks", "004");
        data.put("msisdn", "");
        Map<String, String> data2 = new HashMap<>();
        data2.put("ProductId", "57700000637");
        try {
            RequestHttpByClient.requestTo10086("http://112.35.23.155:18083/dmp/terminalNorthApi/device",  data);
            RequestHttpClient.requestTo10086("http://112.35.23.155:18083/dmp/terminalNorthApi/device", "POST", data);
            RequestHttpClient.requestTo10086("http://112.35.23.155:18080/dmp/terminalNorthApi/product/device", "GET", data2);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
