/**
 * Copyright (C), 2019-2019,
 * FileName: FruitProvider
 * Author:   陈腾帅
 * Date:     2019 3 21 0021 15:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 陈腾帅          修改时间           V1.0              描述
 */
package com.example.annotation;

import java.lang.annotation.*;

/**
 * 水果供应者注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /**
     * 供应商编号
     */
    public int id() default -1;

    /**
     * 供应商名称
     */
    public String name() default "";

    /**
     * 供应商地址
     */
    public String address() default "";
}