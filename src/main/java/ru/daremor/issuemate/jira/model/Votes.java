package ru.daremor.issuemate.jira.model;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
public class Votes {
	
    @JsonProperty
    @Schema(description = "The URL of the votes.")
	URI self;
	
    @JsonProperty
    @Schema(description = "Count of votes.")
	Long votes;
    
    @JsonProperty
    @Schema(description = "voters sign")
	Boolean hasVoted;
    
}
