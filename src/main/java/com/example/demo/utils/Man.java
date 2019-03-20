/**
 * Copyright (C), 2019-2019,
 * FileName: Man
 * Author:   a
 * Date:     2019 3 20 0020 13:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.utils;

import com.example.demo.Impl.QQCar;
import com.example.demo.Interface.ICar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Man {

    private ICar iCar;

    public Man() {
    }

    @Autowired
    public Man(QQCar car) {
        this.iCar = car;
    }

    public void work() {
        iCar.drive();
    }
}
