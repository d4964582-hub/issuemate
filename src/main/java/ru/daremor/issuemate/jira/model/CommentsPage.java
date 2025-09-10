package ru.daremor.issuemate.jira.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import lombok.experimental.Accessors;

import java.util.List;

@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentsPage {

    @JsonProperty
    @Schema(description = "Total number of comments")
    Integer total;

    @JsonProperty
    @Schema(description = "Start offset")
    Integer startAt;

    @JsonProperty
    @Schema(description = "Max results in this page")
    Integer maxResults;

    @JsonProperty("comments")
    @Schema(description = "List of comments")
    @Singular("addComment")
    List<Comment> comments;
}