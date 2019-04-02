/**
 * Copyright (C), 2019-2019,
 * FileName: RequestHttpClient
 * Author:   陈腾帅
 * Date:     2019 3 29 0029 17:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 陈腾帅          修改时间           V1.0              描述
 */
package com.example.common;


import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RequestHttpClient {

    public static String requestTo10086(String url, String requestMethod, Map<String, String> headers, Map<String, String> paras) throws Exception {
        String Signature = "11e46511155fcbbefecc71b1dfda2f02";
        String Timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(new Date());
        String AccessKeyId = "4028808668fe95680168fe9568d3163";
        Map REQ_DATA = new HashMap<String, String>();
        REQ_DATA.put("Signature", Signature);           //签名结果串
        REQ_DATA.put("Timestamp", Timestamp); //请求的时间戳
        REQ_DATA.put("AccessKeyId", AccessKeyId);            //基础平台颁发给用户的访问服务所 用的密钥ID
        REQ_DATA.putAll(paras);
        //String data = JSON.parseObject(REQ_DATA.toString(), String.class);//转化成json
        JSONObject json = new JSONObject(REQ_DATA);
        String data = json.toJSONString();//转成string格式
        System.out.println(data);
        URL httpUrl = new URL(url);
        HttpURLConnection huc = (HttpURLConnection) httpUrl.openConnection();
        huc.setRequestMethod(requestMethod);//请求方式POST或GET
        huc.setDoInput(true);
        huc.setDoOutput(true);
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            huc.setRequestProperty(entry.getKey(), entry.getValue());
        }
        huc.connect();
        OutputStreamWriter writer = new OutputStreamWriter(huc.getOutputStream());           //发送参数
        writer.write(data);        //清理当前编辑器的左右缓冲区，并使缓冲区数据写入基础流
        writer.flush();
        if (huc.getResponseCode() != 200) {
            throw new RuntimeException("HTTP Request Failed with Error code : " + huc.getResponseCode() + huc.getResponseMessage());
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream(), "UTF-8"));
        String line;
        Map js;
        String returninfo = "";
        while ((line = br.readLine()) != null) {
            returninfo = line;
            js = (Map) JSONObject.parseObject(returninfo);
            System.out.println(js.toString());
        }
        huc.disconnect();
        br.close();
        return returninfo;
    }
}

