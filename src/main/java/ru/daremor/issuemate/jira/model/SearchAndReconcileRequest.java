package ru.daremor.issuemate.jira.model;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
public class SearchAndReconcileRequest {

    @JsonProperty
    @Schema(description = "A list of fields to return for each issue. Use it to retrieve a subset of fields. This parameter accepts a comma-separated list.")
    @Singular("addField")
    Set<String> fields;
    
    @JsonProperty
    @Schema(description = "JQL query string", example = "project = HRIMP AND statusCategory != Done")
    String jql;

    @Schema(description = "Max results")
    @Min(1)
    @Max(100)
    @Builder.Default
    Integer maxResults = 5;
}
