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
public class Component {

    @JsonProperty
    @Schema(description = "The URL of the component.")
    URI self;

    @JsonProperty
    @Schema(description = "The name of the component.", example = "Интеграция")
    String name;

    @JsonProperty
    @Schema(description = "The ID of the component.", example = "36400")
    Long id;
}
