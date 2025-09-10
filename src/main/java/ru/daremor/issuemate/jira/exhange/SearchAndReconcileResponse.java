package ru.daremor.issuemate.jira.exhange;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;
import ru.daremor.issuemate.jira.model.Issue;

@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchAndReconcileResponse {

    @JsonProperty("isLast")
    @Schema(description = "Indicates whether this is the last page of the paginated response.")
    boolean isLast;

    @JsonProperty("issues")
    @Schema(description = "The list of issues found by the search or reconsiliation.")
    @Singular("addIssue")
    List<Issue> issues;

    @JsonProperty("nextPageToken")
    @Schema(description = "Continuation token to fetch the next page. If this result represents the last or the only page this token will be null. This token will expire in 7 days.", example = "EgQIlMIC")
    String nextPageToken;
}
