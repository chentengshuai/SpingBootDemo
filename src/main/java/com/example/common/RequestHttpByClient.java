/**
 * Copyright (C), 2019-2019,
 * FileName: RequestHttpByClient
 * Author:   陈腾帅
 * Date:     2019 3 29 0029 17:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 陈腾帅          修改时间           V1.0              描述
 */
package com.example.common;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RequestHttpByClient {

    public static void requestTo10086(String url, Map<String, String> data) {
        String Signature = "82e1b357ca04ad09ff8cc010b3632969";
        String Timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(new Date());
        String AccessKeyId = "4028808868fe93a80168fe93a80a168";
        RestTemplate template = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        Map REQ_DATA = new HashMap<String, String>();
        REQ_DATA.put("Signature", Signature);           //签名结果串
        REQ_DATA.put("Timestamp", Timestamp); //请求的时间戳
        REQ_DATA.put("AccessKeyId", AccessKeyId);            //基础平台颁发给用户的访问服务所 用的密钥ID
        REQ_DATA.putAll(data);
        String requestBody = JSONObject.toJSONString(REQ_DATA);
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("Cookie", "td_cookie=1697431691; cnpost=%7B%22username%22%3A%22haiershangkong%22%2C%22id%22%3A%22430070824%22%2C%22responseMsg%22%3A%22success%22%2C%22orgId%22%3A%2210075004%22%2C%22orgName%22%3A%22%E6%B5%B7%E5%B0%94%E5%95%86%E7%A9%BANB%E7%BD%91%E5%85%B3%22%2C%22distinctId%22%3A%22100000%22%2C%22distinctTypeId%22%3A%2260%22%2C%22serviceCode%22%3A%22%22%2C%22STAFF_ID%22%3A%224373660%22%2C%22avatar%22%3A%22%22%2C%22success%22%3Atrue%7D; session_id=402880ae6993e56f016993e56fda148; sign=7b0ef28405f56496c7c57b49bfea209a; JSESSIONID=79F8354203EDA18F6120DC08B86AB896");
        HttpEntity<String> httpEntity = new HttpEntity<String>(requestBody, headers);
        ResponseEntity<String> response = template.postForEntity(url, httpEntity, String.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("HTTP Request Failed with Error code : " + response.getStatusCode());
        }
    }
}
