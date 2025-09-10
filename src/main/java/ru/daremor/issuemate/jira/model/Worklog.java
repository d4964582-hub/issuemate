package ru.daremor.issuemate.jira.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

import java.net.URI;

@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Worklog {

    @JsonProperty
    @Schema(description = "Self URL")
    URI self;

    @JsonProperty
    @Schema(description = "Worklog ID")
    String id;

    @Nullable
    @JsonProperty
    @Schema(description = "Issue ID (string)")
    String issueId;

    @JsonProperty
    @Schema(description = "Author")
    User author;

    @Nullable
    @JsonProperty
    @Schema(description = "Last update author")
    User updateAuthor;

    @JsonProperty
    @Schema(description = "Started timestamp (as in Jira, e.g. 2021-01-17T12:34:00.000+0000)")
    String started;

    @JsonProperty
    @Schema(description = "Time spent, human readable (e.g., '3h 20m')")
    String timeSpent;

    @JsonProperty
    @Schema(description = "Time spent in seconds")
    Integer timeSpentSeconds;

    @Nullable
    @JsonProperty
    @Schema(description = "Comment text (plain)")
    String comment;

    @Nullable
    @JsonProperty
    @Schema(description = "Visibility settings (role/group)")
    Visibility visibility;
}