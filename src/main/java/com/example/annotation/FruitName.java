/**
 * Copyright (C), 2019-2019,
 * FileName: FruitName
 * Author:   陈腾帅
 * Date:     2019 3 21 0021 14:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 陈腾帅          修改时间           V1.0              描述
 */
package com.example.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;



/**
 * 水果名称注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface FruitName {
    String value() default "";
}
