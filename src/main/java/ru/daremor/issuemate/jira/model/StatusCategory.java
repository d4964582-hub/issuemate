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
public class StatusCategory {
    @JsonProperty @Schema(description = "ID") Long id;
    @JsonProperty @Schema(description = "Key (e.g., new, indeterminate, done)") String key;
    @JsonProperty @Schema(description = "Name") String name;
    @JsonProperty @Schema(description = "Color name") String colorName;
}
