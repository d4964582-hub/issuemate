package ru.daremor.issuemate.jira.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import lombok.experimental.Accessors;

import java.net.URI;

@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attachment {
	@JsonProperty
	@Schema(description = "Self URL")
	URI self;
	@JsonProperty
	@Schema(description = "ID")
	Long id;
	@JsonProperty
	@Schema(description = "Filename")
	String filename;
	@JsonProperty
	@Schema(description = "MIME type")
	String mimeType;
	@JsonProperty
	@Schema(description = "Size (bytes)")
	Long size;
	@JsonProperty
	@Schema(description = "Created timestamp")
	String created;
	@JsonProperty
	@Schema(description = "Content URL")
	String content;
	@JsonProperty
	@Schema(description = "Thumbnail URL")
	String thumbnail;
	@JsonProperty
	@Schema(description = "Author")
	User author;
}
