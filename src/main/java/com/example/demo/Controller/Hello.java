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
import com.example.demo.utils.Test;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@Api(value = "API - HelloController", description = "用户测试的Hello类")
@RestController
public class Hello {

    @Autowired
    private Test test;

    @Value("10.135.12.208")
    String host;
    @Value("6379")
    int port;
    @Value("Haier,123")
    String password;
    @Autowired
    private SayHelloByName sayHelloByName;

    /**
    * @Description:   返回HelloChenTengShuai
    * @Param:
    * @return:  Hello:ChenTengShuai
    * @Author: 陈腾帅
    * @Date: 2019-03-20
    */
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

    /**
     * @Description: 使用redis缓存数据初例
     * @Param: 需要保存的数据
     * @return:
     * @Author: 陈腾帅
     * @Date: 2019-03-21
     */
    @RequestMapping(value = "useRedisIndex", method = RequestMethod.GET)
    public String useRedisIndex() {
        String result = "";
        try {
            //使用前确保redis服务已经开启反对
            //通过地址和端口号进行认证
            Jedis jedis = new Jedis(host, port);
            //存在密码时使用密码认证
            jedis.auth(password);
            jedis.set("name", "张三");
            jedis.set("age", "18");
            String s = jedis.get("name");
            String s1 = jedis.get("age");
            System.out.println(s);
            System.out.println(s1);
            result = "成功！";
        } catch (Exception e) {
            result = "失败：" + e.toString();
        }
        return result;
    }
}