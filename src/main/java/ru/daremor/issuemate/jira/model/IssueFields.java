package ru.daremor.issuemate.jira.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

import java.util.List;

@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IssueFields {

    @JsonProperty
    @Schema(description = "Summary of the issue.")
    String summary;

    @Nullable
    @JsonProperty
    @Schema(description = "Description of the issue (plain text).")
    String description;

    @JsonProperty
    @Schema(description = "Issue type.")
    IssueType issuetype;

    @JsonProperty
    @Schema(description = "Current status.")
    Status status;

    @JsonProperty
    @Schema(description = "Priority of the issue.")
    Priority priority;

    @JsonProperty
    @Schema(description = "Project reference.")
    ProjectRef project;

    @JsonProperty
    @Schema(description = "Assignee user.")
    User assignee;

    @JsonProperty
    @Schema(description = "Reporter user.")
    User reporter;

    @JsonProperty
    @Schema(description = "Labels.")
    @Singular("addLabel")
    List<String> labels;

    @JsonProperty
    @Schema(description = "Components.")
    @Singular("addComponent")
    List<Component> components;

    @JsonProperty
    @Schema(description = "Fix versions.")
    @Singular("addFixVersion")
    List<VersionRef> fixVersions;

    @JsonProperty
    @Schema(description = "Affects versions.")
    @Singular("addAffectsVersion")
    List<VersionRef> versions;

    @JsonProperty
    @Schema(description = "Time tracking info.")
    TimeTracking timetracking;

    @JsonProperty
    @Schema(description = "Watchers info (isWatching, watchCount).")
    Watcher watcher;

    @JsonProperty("sub-tasks")
    @Schema(description = "Sub-tasks of the issue.")
    @Singular("addSubtask")
    List<SubTask> subtasks;

    @JsonProperty
    @Schema(description = "Issue links.")
    @Singular("addIssueLink")
    List<IssueLink> issuelinks;

    @JsonProperty
    @Schema(description = "Attachments.")
    @Singular("addAttachment")
    List<Attachment> attachment;

    @JsonProperty
    @Schema(description = "Resolution (if resolved).")
    Resolution resolution;

    @JsonProperty
    @Schema(description = "Resolution date (string as in Jira, e.g. 2021-01-18T23:45:00.000+0000).")
    String resolutiondate;

    @JsonProperty
    @Schema(description = "Due date (YYYY-MM-DD).")
    String duedate;

    @JsonProperty
    @Schema(description = "Created timestamp (string as in Jira).")
    String created;

    @JsonProperty
    @Schema(description = "Updated timestamp (string as in Jira).")
    String updated;
}
