/**
 * Copyright (C), 2019-2019,
 * FileName: FruitRun
 * Author:   陈腾帅
 * Date:     2019 3 21 0021 15:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 陈腾帅          修改时间           V1.0              描述
 */
package com.example.demo;

import com.example.demo.model.Apple;
import com.example.demo.utils.FruitInfoUtil;

public class FruitRun {
    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}
