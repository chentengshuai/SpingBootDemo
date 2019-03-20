/**
 * Copyright (C), 2019-2019,
 * FileName: ManTest
 * Author:   a
 * Date:     2019 3 20 0020 15:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo;

import com.example.demo.Config.CarConfig;
import com.example.demo.utils.Man;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml") //加载XML配置的方式
public class ManTest {

    @Autowired
    Man man;

    @Test
    public void manTest() {
        man.work();
    }
}
