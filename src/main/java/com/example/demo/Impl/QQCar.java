/**
 * Copyright (C), 2019-2019,
 * FileName: QQCar
 * Author:   a
 * Date:     2019 3 20 0020 10:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.Impl;

import com.example.demo.Interface.ICar;
import org.springframework.stereotype.Component;

@Component
public class QQCar implements ICar {

    @Override
    public void drive() {
        System.out.println("QQCar.drive()");
    }
}
