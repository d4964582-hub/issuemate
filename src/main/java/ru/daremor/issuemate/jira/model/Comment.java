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
public class Comment {

    @JsonProperty
    @Schema(description = "Self URL")
    URI self;

    @JsonProperty
    @Schema(description = "Comment ID")
    String id;

    @JsonProperty
    @Schema(description = "Author")
    User author;

    @Nullable
    @JsonProperty
    @Schema(description = "Last update author")
    User updateAuthor;

    @JsonProperty
    @Schema(description = "Created timestamp (as in Jira, e.g. 2021-01-17T12:34:00.000+0000)")
    String created;

    @Nullable
    @JsonProperty
    @Schema(description = "Updated timestamp")
    String updated;

    @JsonProperty
    @Schema(description = "Comment body (plain text; ADF is omitted here to keep it simple)")
    String body;

    @Nullable
    @JsonProperty
    @Schema(description = "Visibility settings (role/group)")
    Visibility visibility;
}