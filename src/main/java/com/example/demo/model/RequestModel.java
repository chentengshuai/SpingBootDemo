/**
 * Copyright (C), 2019-2019,
 * FileName: RequestModel
 * Author:   陈腾帅
 * Date:     2019 4 4 0004 9:55
 * Description: 请求API实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 陈腾帅          修改时间           V1.0              描述
 */

package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class RequestModel implements Serializable {
    //请求的地址
    private String httpUrl;
    //请求的josn数据
    private String data;
    //请求的Cookie
    private List<RequestHeader> requestHeaders;

    //请求的Cookie
    private String contentType;

    private static final long serialVersionUID = -3620991473521824562L;

}
