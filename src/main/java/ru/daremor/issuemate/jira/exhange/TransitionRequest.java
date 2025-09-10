package ru.daremor.issuemate.jira.exhange;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;
import ru.daremor.issuemate.jira.model.IssueTransition;

@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
public class TransitionRequest {

    @JsonProperty
    @Schema(description = "Expand options that include additional transitions details in the response.", example = "transitions")
    String expand;
    
    @JsonProperty
    @Schema(description = "List of issue transitions.")
    @Singular("addTransition")
    List<IssueTransition> transitions;

}
