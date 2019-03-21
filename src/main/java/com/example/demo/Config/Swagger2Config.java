/**
 * Copyright (C), 2019-2019,
 * FileName: Swagger2Config
 * Author:   陈腾帅
 * Date:     2019 3 21 0021 8:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 陈腾帅          修改时间           V1.0              描述
 */
package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//访问http://localhost:8080/swagger-ui.html
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.Controller"))
                        .paths(PathSelectors.any())
                        .build()
                        .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测试接口平台API")
                .description("cathy demo  API.")
                        .termsOfServiceUrl("Terms of service")
                        .contact("729027995@qq.com")
                        .version("1.0")
                        .build();
    }
}