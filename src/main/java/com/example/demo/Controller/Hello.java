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

import com.example.common.SayHelloByName;
import com.example.common.SpringContextUtil;
import com.example.demo.utils.Test;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @Autowired
    private Test test;

//    @Autowired
//    private SayHelloByName sayHelloByName;

    /**
    * @Description:   返回HelloChenTengShuai
    * @Param:
    * @return:  Hello:ChenTengShuai
    * @Author: 陈腾帅
    * @Date: 2019-03-20
    */
//    @RequestMapping("/SayHelloChenTengShuai")
//    public String SayHelloChenTengShuai() {
//        SayHelloByName sayHelloByName = SpringContextUtil.getBean("sayHelloByName",SayHelloByName.class);
//        return sayHelloByName.sayHelloByName("ChenTengShuai");
//    }


    @Autowired
    private SayHelloByName sayHelloByName;

    @RequestMapping("/SayHelloAutowired")
    public String SayHelloChenTengShuai() {
        return sayHelloByName.sayHelloByName("ChenTengShuai");
    }

    /** 
    * @Description: 显示默认页面
    * @Param:  
    * @return:  默认页面
    * @Author: 陈腾帅
    * @Date: 2019-03-20 
    */
    @RequestMapping("/")
    public String index() {
        return "默认页面";
    }

    
    /**
    * @Description:   返回给前台hello:chentengshuai
    * @Param:
    * @return:
    * @Author: 陈腾帅
    * @Date: 2019-03-20
    */
    @RequestMapping("/SayHelloByName")
    public String sayHelloByName() {
        String result = test.sayHelloByName("chentengshuai");
        return result;
    }
}