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

import com.alibaba.fastjson.JSONObject;
import com.example.common.HttpClientUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        try {
            Map dataReg = new HashMap<String, String>();


            dataReg.put("Timestamp", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(new Date())); //请求的时间戳

            dataReg.put("deviceName", "wangltpostmanadd");
            dataReg.put("productId", "57700000637");
            dataReg.put("terminalSN", "122100010014");
            dataReg.put("remarks", "004");
            dataReg.put("msisdn", "");
            dataReg.put("customerId", "wangliangtao_test");


            String strLogin = HttpClientUtil.sendHttpPost("http://112.35.81.139:18080/sso-web/UspaCsfCrmServlet?servicecode=uspa_IOrgmodelClientCSV_loginIn", "params={\"userCode\":\"ADMIN\",\"passWord\":\"Test@1234\"}");
            JSONObject jsonLogin = JSONObject.parseObject(strLogin);
            JSONObject loginData = jsonLogin.getJSONObject("data");
            dataReg.put("sign", loginData.get("GLOBAL_SIGN").toString());//签名结果串
            dataReg.put("session_id", loginData.get("GLOBAL_SESSION_ID").toString()); //基础平台颁发给用户的访问服务所 用的密钥ID
            String strReg = new JSONObject(dataReg).toJSONString();
            String result4 = HttpClientUtil.sendHttpPostJson("http://112.35.81.139:18080/dmp/terminalNorthApi/device", strReg);
            System.out.println(result4);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
