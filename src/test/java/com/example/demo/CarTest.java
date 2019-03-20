/**
 * Copyright (C), 2019-2019,
 * FileName: CarTest
 * Author:   a
 * Date:     2019 3 20 0020 10:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo;

import com.example.demo.Config.CarConfig;
import com.example.demo.Impl.QQCar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertNotNull;

/**
 * 注解释义：
 * @RunWith(SpringJUnit4ClassRunner.class)  测试在Spring环境中运行
 * @ContextConfiguration  上下文配置注解，指定配置文件（Java类或XML文件）的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CarConfig.class) //加载Java配置类的方式
//@ContextConfiguration(locations = "classpath:applicationContext.xml") //加载XML配置的方式
public class CarTest {
    @Autowired
    private QQCar car ;

    @Test
    public void carTest(){
        car.drive();
    }
}