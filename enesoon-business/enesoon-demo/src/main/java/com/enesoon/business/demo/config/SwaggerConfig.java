package com.enesoon.business.demo.config;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.RequestHandlerSelectors;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket userApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.enesoon.business.demo.controller.*"))//过滤的接口
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(Predicates.or(RequestHandlerSelectors.basePackage("com.enesoon.business.demo.controller.swagger"),
                		            RequestHandlerSelectors.basePackage("com.enesoon.business.demo.controller.db")))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("服务端提供者接口平台").description("服务相关数据接口")
                .termsOfServiceUrl("http://www.zhang.box.cn/").contact("技术开发部")
                .license("Licence Version 1.0").licenseUrl("#").version("1.0").build();
    }

}
