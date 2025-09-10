package ru.daremor.issuemate;

import java.net.URI;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Validated
@ConfigurationProperties(prefix = "issuemate.jira")
public record JiraProperties(

        /** Базовый URL Jira без хвостового / (пример: https://jira.company.ru) */
        @NotNull URI baseUrl,

        /** Personal Access Token для Jira DC/Server. Будет отправляться как Bearer. */
        @NotBlank String pat,
        
        @NotBlank String projectKey

) {}
