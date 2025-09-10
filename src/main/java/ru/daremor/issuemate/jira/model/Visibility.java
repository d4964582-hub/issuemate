package ru.daremor.issuemate.jira.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import lombok.experimental.Accessors;

@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Visibility {

    @JsonProperty
    @Schema(description = "Type of the visibility restriction (e.g., 'role' or 'group')")
    String type;

    @JsonProperty
    @Schema(description = "Human-friendly value (e.g., 'Administrators' or group name)")
    String value;

    @JsonProperty
    @Schema(description = "Identifier (role/group key), if provided")
    String identifier;
}