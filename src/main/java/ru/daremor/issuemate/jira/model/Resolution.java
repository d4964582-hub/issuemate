package ru.daremor.issuemate.jira.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import lombok.experimental.Accessors;

import java.net.URI;

@Value @Builder @Jacksonized @Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Resolution {
    @JsonProperty @Schema(description = "Self URL") URI self;
    @JsonProperty @Schema(description = "ID") Long id;
    @JsonProperty @Schema(description = "Name") String name;
}
