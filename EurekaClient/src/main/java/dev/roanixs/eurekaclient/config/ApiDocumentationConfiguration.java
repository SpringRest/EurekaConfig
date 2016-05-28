package dev.roanixs.eurekaclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by coumaj on 28/05/2016.
 */
@Configuration
public class ApiDocumentationConfiguration {

    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("greetings")
                .apiInfo(metadata())
                .select()
                .paths(regex("/greeting.*"))
                .build()
                .pathMapping("/");
    }

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfiguration.DEFAULT;
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("My awesome API")
                .description("Some description")
                .version("1.0")
                .contact("my-email@domain.org")
                .build();
    }

}
