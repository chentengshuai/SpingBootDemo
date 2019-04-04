/**
 * Copyright (C), 2019-2019,
 * FileName: RequestHeader
 * Author:   陈腾帅
 * Date:     2019 4 4 0004 18:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 陈腾帅          修改时间           V1.0              描述
 */
package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class RequestHeader implements Serializable {
    private static final long serialVersionUID = 643723735030745560L;
    private String code;
    private String value;

    public RequestHeader(String code, String value) {
        this.code = code;
        this.value = value;
    }
}
