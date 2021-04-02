package com.example.begine.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 反正就是設定 我也還沒研究 直接照抄就好
     * http://127.0.0.1:8000/api/swagger-ui.html   swagger 從這個網址去看
     */
    @Bean
    public Docket swaggerSetting() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Arrays.asList(apiKey()));
    }

    // 進入畫面上方的說明
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Nineder backend platform")
                .description("Read me~~\n" +
                        "")
                .version("v0.0.0.0")
                .build();
    }

    // 這個是有些API 需要加一些資訊在header 時可以用的東西 name 是給人看的 keyname 是header 裡的名字 passAs 是傳遞的方式
    // 這邊就是要在header 裡面加入 Authorization 這個東西
    private ApiKey apiKey() {
        return new ApiKey("jwtToken", "Authorization", "header");
    }

}
