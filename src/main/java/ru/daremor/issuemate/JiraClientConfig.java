package ru.daremor.issuemate;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
@EnableConfigurationProperties(JiraProperties.class)
public class JiraClientConfig {

    @Bean
    RestClient jiraRestClient(JiraProperties props) {
        return RestClient.builder()
            .baseUrl(props.baseUrl().toString())
            .build();
    }
}
