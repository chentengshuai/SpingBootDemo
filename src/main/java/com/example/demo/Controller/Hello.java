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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "API - HelloController", description = "用户测试的Hello类")
@RestController
public class Hello {

    @Autowired
    private Test test;

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

    @RequestMapping(value = "/SayHelloAutowired",method= RequestMethod.GET)
    public String SayHelloChenTengShuai(@RequestParam(value="name", required=false, defaultValue="ChenTengShuai")String name) {
        return sayHelloByName.sayHelloByName(name);
    }

    /** 
    * @Description: 显示默认页面
    * @Param:  
    * @return:  默认页面
    * @Author: 陈腾帅
    * @Date: 2019-03-20 
    */
    @RequestMapping(value = "/",method= RequestMethod.GET)
    @ApiOperation(value = "默认页面", notes = "index")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "name", required = false,
                    dataType = "string", paramType = "query", defaultValue = "默认页面")
    })
    public String index(@RequestParam(value="name", required=false, defaultValue="默认页面")String name) {
        return name;
    }

    
    /**
    * @Description:   返回给前台hello:chentengshuai
    * @Param:
    * @return:
    * @Author: 陈腾帅
    * @Date: 2019-03-20
    */
    @RequestMapping(value = "SayHelloByName",method= RequestMethod.GET)
    public String sayHelloByName(@RequestParam(value="name", required=false, defaultValue="ChenTengShuai")String name) {
        String result = test.sayHelloByName(name);
        return result;
    }
}