/**
 * Copyright (C), 2019-2019,
 * FileName: Hello
 * Author:   a
 * Date:     2019 3 19 0019 17:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.Controller;

import com.example.demo.utils.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    //@Autowired
    //private Test test;

    @RequestMapping("/SayHello")
    public String stringHello() {
        return "Hello World!";
    }

    @RequestMapping("/")
    public String index() {
        return "默认页面";
    }

   // @RequestMapping("/SayHelloByName")
   // public String sayHelloByName() {
    //    String result=test.sayHelloByName("chentengshuai");
     //   return result;
    //}
}