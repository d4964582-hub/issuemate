package ru.daremor.issuemate.jira.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.net.URI;

@Validated
@ConfigurationProperties(prefix = "issuemate.jira")
public record JiraProperties(
        @NotNull URI baseUrl,
        @NotBlank String pat,
        String defaultProjectKey,
        boolean defaultAssigneeSelf,
        Integer connectTimeoutMs,
        Integer readTimeoutMs
) {}
