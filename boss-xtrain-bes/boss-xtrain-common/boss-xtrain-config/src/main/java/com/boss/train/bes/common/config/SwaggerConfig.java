package com.boss.train.bes.common.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *Swagger配置
 *
 * @author yushiqian
 * @date 2020/07/03
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig{

    @Bean
    public Docket createResApi(){
//        List<Parameter> parameters = new ArrayList<>();
//        parameters.add(authorizationParameter());
//        parameters.add(tenantCodeParameter());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
//                .globalOperationParameters(parameters);
    }
//
//    /**
//     * Authorization 请求头
//     *
//     * @return Parameter
//     */
//    private Parameter authorizationParameter(){
//        ParameterBuilder tokenBuilder = new ParameterBuilder();
//        tokenBuilder.name("Authorization")
//                .description("access_token")
//                .modelRef(new ModelRef("string"))
//                .parameterType("header")
//                .required(false).build();
//        return tokenBuilder.build();
//    }
//
//    /**
//     * Tenant-Code 请求头
//     *
//     * @return Parameter
//     */
//    private Parameter tenantCodeParameter(){
//        ParameterBuilder tokenBuilder = new ParameterBuilder();
//        tokenBuilder.name("Tenant-Code")
//                .defaultValue("gitee")
//                .description("租户标识")
//                .modelRef(new ModelRef("string"))
//                .parameterType("header")
//                .required(false).build();
//        return tokenBuilder.build();
//    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("winterProject API doc")
                .description("this is a restful api document of WP")
//                .termsOfServiceUrl("https://gitee.com/wells2333/spring-microservice-exam")
//                .contact(new Contact("tangji","https://gitee.com/wells2333/spring-microservice-exam","2297764654@qq.com"))
                .version("1.0")
                .build();
    }


}
