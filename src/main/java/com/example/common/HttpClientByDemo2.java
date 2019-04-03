/**
 * Copyright (C), 2019-2019,
 * FileName: HttpClientByDemo
 * Author:   陈腾帅
 * Date:     2019 4 2 0002 15:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 陈腾帅          修改时间           V1.0              描述
 */
package com.example.common;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class HttpClientByDemo2 {
    public static String request(String url) {
        try {
            HttpClient client = HttpClients.createDefault();
            HttpPost request = new HttpPost(url);
            StringEntity stringEntity = new StringEntity("{\n" +
                    "    \"productId\":\"57700000637\",\n" +
                    "    \"customerId\":\"wangliangtao_test\",\n" +
                    "    \"terminalSN\":\"122100010014\",\n" +
                    "    \"msisdn\":\"\",\n" +
                    "    \"Timestamp\":\"2019-04-02T11:07:29+08:00\",\n" +
                    "    \"deviceName\":\"wangltpostmanadd\",\n" +
                    "    \"remarks\":\"004\"\n" +
                    "}", "UTF-8");
            stringEntity.setContentType("application/json;charset=utf-8");
            request.setEntity(stringEntity);
            request.setHeader("sign","91a02eb9c5d4cf4f14e1cf9520197ca0");
            request.setHeader("session_id","4028808668fe95680168fe9568d3168");
            //request.setHeader("Cookie", "td_cookie=1783141882; cnpost=%7B%22username%22%3A%22%E7%AE%A1%E7%90%86%E4%BA%BA%E5%91%98%22%2C%22id%22%3A%22430065424%22%2C%22responseMsg%22%3A%22success%22%2C%22orgId%22%3A%2210006404%22%2C%22orgName%22%3A%22%E4%B8%AD%E5%9B%BD%E7%A7%BB%E5%8A%A8%E6%94%BF%E4%BC%81%E5%88%86%E5%85%AC%E5%8F%B8change%22%2C%22distinctId%22%3A%22100000%22%2C%22distinctTypeId%22%3A%2260%22%2C%22serviceCode%22%3A%22%22%2C%22STAFF_ID%22%3A%224368260%22%2C%22avatar%22%3A%22%22%2C%22success%22%3Atrue%7D; session_id=4028808668fe95680168fe9568d3168; sign=91a02eb9c5d4cf4f14e1cf9520197ca0; JSESSIONID=2DD153F20467550C89FD5985D7FE4B1B");
            HttpResponse response = client.execute(request);//获取状态行
            StatusLine line = response.getStatusLine();//获取状态码
            int code = line.getStatusCode();
            if (code != 200) {
                throw new RuntimeException("HTTP Request Failed with Error code : " + code);
            }
            HttpEntity entity = response.getEntity();
            String ll="";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public static void main(String[] args) {
        HttpClientByDemo2.request("http://112.35.81.139:18080/dmp/terminalNorthApi/device");
    }
}

