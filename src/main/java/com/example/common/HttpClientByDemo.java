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

import ch.qos.logback.core.db.dialect.SybaseSqlAnywhereDialect;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HttpClientByDemo {
    public static String request(String url) {
        String result = "";
        try {
            HttpClient client = HttpClients.createDefault();
            HttpPost request = new HttpPost(url);
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("sign", "cc08d7bad5f6e910ab48c0bc353702b7"));//签名结 果串
            //nvps.add(new BasicNameValuePair("Timestamp", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(new Date())));//请求的时间戳
            nvps.add(new BasicNameValuePair("session_id", "4028808668fe95680168fe9568d3171"));//基础平 台颁发给用户的访问服务所用的密钥ID
            //设置请求参数
            nvps.add(new BasicNameValuePair("customerId", "wangliangtao_test"));
            nvps.add(new BasicNameValuePair("productId", "57700000637"));
            nvps.add(new BasicNameValuePair("deviceName", "wangltpostmanadd"));
            nvps.add(new BasicNameValuePair("terminalSN", "122100010014"));
            nvps.add(new BasicNameValuePair("remarks", "004"));
            nvps.add(new BasicNameValuePair("msisdn", ""));
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nvps, "UTF-8");
            formEntity.setContentType("application/json");
            request.setEntity(formEntity);
            request.setHeader("sign","cc08d7bad5f6e910ab48c0bc353702b7");
            request.setHeader("session_id","4028808668fe95680168fe9568d3171");
            HttpResponse response = client.execute(request);//获取状态行
            StatusLine line = response.getStatusLine();//获取状态码
            int code = line.getStatusCode();
            if (code != 200) {
                throw new RuntimeException("HTTP Request Failed with Error code : " + code);
            }
            HttpEntity entity = response.getEntity();
            result = "OK";
        } catch (Exception e) {
            result = e.toString();
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(HttpClientByDemo.request("http://112.35.81.139:18080/dmp/terminalNorthApi/device"));
    }
}

