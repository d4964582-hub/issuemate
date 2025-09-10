package ru.daremor.issuemate.jira.api;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
@EnableConfigurationProperties(JiraProperties.class)
public class JiraClientConfig {

    @Bean
    RestClient jiraRestClient(RestClient.Builder builder, JiraProperties props) {
        return builder
                .baseUrl(props.baseUrl().toString())
                .requestInterceptor((request, body, execution) -> {
                    request.getHeaders().add("x-custom-token", props.pat());
                    return execution.execute(request, body);
                })
                .build();
    }
}
