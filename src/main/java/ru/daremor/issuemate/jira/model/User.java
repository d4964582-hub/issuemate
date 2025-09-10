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
@Schema(description = "Jira user.")
public class User {
	
    @JsonProperty
    @Schema(description = "The URL of the user.")
	URI self;
	
    @JsonProperty
    @Schema(description = "The name of the user.", example = "16734748")
	String name;
	
    @JsonProperty
    @Schema(description = "The key of the user.", example = "16734748")
	Long key;
    
    @JsonProperty
    @Schema(description = "The email of the user.", example = "Larin.D.Yury@sberbank.ru")
    String emailAddress;
    
    @JsonProperty
    @Schema(description = "Display name", example = "Ларин Дмитрий Юрьевич")
    String displayName;

}
