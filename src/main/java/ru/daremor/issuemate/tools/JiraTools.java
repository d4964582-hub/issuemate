package ru.daremor.issuemate.tools;

import java.net.URI;
import java.time.Instant;
import java.util.Set;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import ru.daremor.issuemate.jira.exhange.SearchAndReconcileResponse;
import ru.daremor.issuemate.jira.model.Issue;
import ru.daremor.issuemate.jira.model.IssueFields;

@Component
@Validated
public class JiraTools {

    @Tool(description = "Execute a Jira JQL search. Prints the request params to console and returns a short summary.")
    public SearchAndReconcileResponse searchJql(
            @ToolParam(required = true, description = "JQL query string (required), e.g. project = HRIMP AND statusCategory != Done")
            String jql,

            @ToolParam(required = false, description = "A set of fields to return (optional). Default fields: description, summary")
            Set<String> fields,

            @ToolParam(required = false, description = "Max results. Default: 5")
            @Min(1)
            @Max(100)
            Integer maxResults,
            
            @ToolParam(required = false, description = "Opaque pagination token from previous page.")
            String nextPageToken
    ) {
        // --- defaults & normalization ---
        final int defaultMax = 5;

        String _jql = jql == null ? "" : jql.trim();
        if (_jql.isEmpty()) {
            // пустой результат, если JQL не задан
            return SearchAndReconcileResponse.builder()
                    .isLast(true)
                    .build();
        }

        int _max = (maxResults == null) ? defaultMax : Math.max(1, Math.min(100, maxResults));
        String _cursor = (nextPageToken == null || nextPageToken.isBlank()) ? null : nextPageToken;

        // demo-лог
        System.out.println("[IssueMate] JQL SEARCH (stub)");
        System.out.println("  jql           = " + _jql);
        System.out.println("  fields        = " + fields);
        System.out.println("  maxResults    = " + _max);
        System.out.println("  nextPageToken = " + _cursor);

        // --- build stub issues ---
        var resultBuilder = SearchAndReconcileResponse.builder();

        for (int i = 1; i <= _max; i++) {
            long id = 10000L + i;
            var issue = Issue.builder()
                    .id(id)
                    .key("IM-" + (1000 + i))
                    .self(URI.create("https://jira.example/rest/api/2/issue/HRIMP-" + (1000 + i)))
                    .fields(IssueFields.builder()
                            .summary("Mock summary for: " + _jql)
                            .description("Mock description #" + i + " (fields=" + fields + ")")
                            .build())
                    .build();

            resultBuilder.addIssue(issue);
        }

        // Примитивная пагинация в stub: если вернули ровно _max, считаем, что есть следующая страница
        boolean hasNext = new java.security.SecureRandom().nextBoolean();
        String next = hasNext ? ("tok-" + Instant.now().toEpochMilli()) : null;

        return resultBuilder
                .isLast(!hasNext)
                .nextPageToken(next)
                .build();
    }
}