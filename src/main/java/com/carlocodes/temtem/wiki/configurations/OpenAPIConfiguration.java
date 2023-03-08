package com.carlocodes.temtem.wiki.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {
    @Value("${temtem-wiki.project.version}")
    private String projectVersion;

    @Bean
    public OpenAPI temtemWikiOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Temtem Wiki API")
                        .version(projectVersion));
    }
}
