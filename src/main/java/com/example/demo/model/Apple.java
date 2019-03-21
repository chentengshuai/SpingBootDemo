/**
 * Copyright (C), 2019-2019,
 * FileName: Apple
 * Author:   陈腾帅
 * Date:     2019 3 21 0021 15:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 陈腾帅          修改时间           V1.0              描述
 */
package com.example.demo.model;

import com.example.annotation.FruitColor;
import com.example.annotation.FruitName;
import com.example.annotation.FruitProvider;

/**
 * 注解使用
 */
public class Apple {

    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor = com.example.annotation.FruitColor.Color.RED)
    private String appleColor;

    @FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市延安路89号红富士大厦")
    private String appleProvider;

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleName() {
        return appleName;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void displayName() {
        System.out.println("水果的名字是：苹果");
    }
}
