package ru.daremor.issuemate.jira.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import lombok.experimental.Accessors;

import java.net.URI;

@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Issue {

    @JsonProperty
    @Schema(description = "The URL of the issue details.")
    URI self;

    @JsonProperty
    @Schema(description = "The key of the issue.", example = "HRIMP-12345")
    String key;

    @JsonProperty
    @Schema(description = "The ID of the issue.")
    Long id;

    @JsonProperty
    @Schema(description = "Collection of system and custom issue fields.")
    IssueFields fields;
}
