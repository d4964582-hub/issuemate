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
public class SubTask {
    @JsonProperty @Schema(description = "ID") String id;
    @JsonProperty @Schema(description = "Link to issue") LinkedIssueRef outwardIssue;
    @JsonProperty @Schema(description = "Type name (e.g., Sub-task)") String typeName;
}
