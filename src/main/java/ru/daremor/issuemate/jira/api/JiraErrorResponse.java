package ru.daremor.issuemate.jira.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import java.util.List;
import java.util.Map;

@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
class JiraErrorResponse {
    @JsonProperty List<String> errorMessages;
    @JsonProperty Map<String, String> errors;
}
