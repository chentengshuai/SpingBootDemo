/**
 * Copyright (C), 2019-2019,
 * FileName: Test
 * Author:   a
 * Date:     2019 3 19 0019 17:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.utils;

import org.springframework.stereotype.Component;

@Component
public class Test {

    public String sayHelloByName(String name) {
        return "你好:" + name;
    }
}
