package com.ideaaedi.boot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * Swagger配置
 */
@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("文档标题：大海啊你全是水~")
                        .contact(
                                new Contact().name("JustryDeng").email("13548417409@163.com")
                        )
                        .version("1.0.0")
                        .description( "spring-boo-jd")
                        .termsOfService("https://gitee.com/JustryDeng/projects"));
    }
    
}
