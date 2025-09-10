package ru.daremor.issuemate.jira.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IssueTransition {

    @JsonProperty
    @Schema(description = "The name of the transition.", example = "Stop Progress")
    String name;

    @JsonProperty
    @Schema(description = "The ID of the transition.", example = "31")
    Long id;
}
