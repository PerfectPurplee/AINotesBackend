package com.ainotes.backendainotes.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Value("${openai.key}")
    private String openApiKey;

    @Bean
    public RestTemplate initResTemplate() {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization",
                    "Bearer " + openApiKey);
            return execution.execute(request, body);
        });

        return restTemplate;
    }

}
