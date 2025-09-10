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
public class TimeTracking {
    @JsonProperty @Schema(description = "Original estimate (e.g., 3h 20m)") String originalEstimate;
    @JsonProperty @Schema(description = "Original estimate seconds") Integer originalEstimateSeconds;
    @JsonProperty @Schema(description = "Remaining estimate") String remainingEstimate;
    @JsonProperty @Schema(description = "Remaining estimate seconds") Integer remainingEstimateSeconds;
    @JsonProperty @Schema(description = "Time spent") String timeSpent;
    @JsonProperty @Schema(description = "Time spent seconds") Integer timeSpentSeconds;
}
