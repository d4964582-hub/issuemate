package ru.daremor.issuemate.jira.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import lombok.experimental.Accessors;

@Value @Builder @Jacksonized @Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinkType {
    @JsonProperty @Schema(description = "ID") String id;
    @JsonProperty @Schema(description = "Name") String name;
    @JsonProperty @Schema(description = "Inward") String inward;
    @JsonProperty @Schema(description = "Outward") String outward;
}
