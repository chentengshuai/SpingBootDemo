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
        String Signature = "11e46511155fcbbefecc71b1dfda2f02";
        String Timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(new Date());
        String AccessKeyId = "4028808668fe95680168fe9568d3163";
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
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        headers.add("Cookie", "td_cookie=1783141882; cnpost=%7B%22username%22%3A%22%E7%AE%A1%E7%90%86%E4%BA%BA%E5%91%98%22%2C%22id%22%3A%22430065424%22%2C%22responseMsg%22%3A%22success%22%2C%22orgId%22%3A%2210006404%22%2C%22orgName%22%3A%22%E4%B8%AD%E5%9B%BD%E7%A7%BB%E5%8A%A8%E6%94%BF%E4%BC%81%E5%88%86%E5%85%AC%E5%8F%B8change%22%2C%22distinctId%22%3A%22100000%22%2C%22distinctTypeId%22%3A%2260%22%2C%22serviceCode%22%3A%22%22%2C%22STAFF_ID%22%3A%224368260%22%2C%22avatar%22%3A%22%22%2C%22success%22%3Atrue%7D; session_id=4028808868fe93a80168fe93a80a172; sign=ddf425ca488e8666b8337289008ef54e; JSESSIONID=68EA2849E90A58E77D513A3BB97566E1");
        HttpEntity<String> httpEntity = new HttpEntity<String>(requestBody, headers);
        ResponseEntity<String> response = template.postForEntity(url, httpEntity, String.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("HTTP Request Failed with Error code : " + response.getStatusCode());
        } else {
            System.out.println(response.toString());
        }
    }
}
