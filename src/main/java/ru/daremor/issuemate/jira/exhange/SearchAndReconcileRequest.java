package ru.daremor.issuemate.jira.exhange;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
public class SearchAndReconcileRequest {
	
    @JsonProperty
    @Schema(description = "Use expand to include additional information about issues in the response. Note that, unlike the majority of instances where expand is specified, expand is defined as a comma-delimited string of values.", example = "names,changelog")
    String expand;

    @JsonProperty
    @Schema(description = "A list of fields to return for each issue. Use it to retrieve a subset of fields. This parameter accepts a comma-separated list.", example = "summary,comment")
    @Singular("addField")
    Set<String> fields;
    
    @JsonProperty
    @Schema(description = "JQL query string", example = "project = HRIMP AND statusCategory != Done")
    String jql;
    
    @JsonProperty
    @Schema(description = "The token for a page to fetch that is not the first page. The first page has a nextPageToken of null. Use the nextPageToken to fetch the next page of issues.")
    String nextPageToken;

    @Schema(description = "The maximum number of items to return per page. To manage page size, API may return fewer items per page where a large number of fields are requested. The greatest number of items returned per page is achieved when requesting id or key only. It returns max 50 issues.")
    @Min(1)
    @Max(50)
    @Builder.Default
    Integer maxResults = 5;
}
