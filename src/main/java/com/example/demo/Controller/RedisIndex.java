/**
 * Copyright (C), 2019-2019,
 * FileName: RedisIndex
 * Author:   陈腾帅
 * Date:     2019 3 28 0028 16:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 陈腾帅          修改时间           V1.0              描述
 */
package com.example.demo.Controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
@Api(value = "API - RedisIndex", description = "RedisIndex")
@RestController
public class RedisIndex {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    /**
     * @Description:   HelloRedis
     * @Param:
     * @return:  RedisIndex:HelloRedis
     * @Author: 陈腾帅
     * @Date: 2019-03-20
     */
    @RequestMapping(value = "/HelloRedis",method= RequestMethod.GET)
    public void HelloRedis(@RequestParam(value="name", required=false, defaultValue="ChenTengShuai")String name) {
        Map<Object,Object> map=new HashMap<Object,Object>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        map.put("key5","value5");
        redisTemplate.opsForHash().putAll("map1",map);
        Map<Object,Object> resultMap= redisTemplate.opsForHash().entries("map1");
        List<Object>reslutMapList=redisTemplate.opsForHash().values("map1");
        Set<Object> resultMapSet=redisTemplate.opsForHash().keys("map1");
        Object value=(Object)redisTemplate.opsForHash().get("map1","key1");
        System.out.println("value:"+value);
        System.out.println("resultMapSet:"+resultMapSet);
        System.out.println("resultMap:"+resultMap);
        System.out.println("resulreslutMapListtMap:"+reslutMapList);
    }
}
