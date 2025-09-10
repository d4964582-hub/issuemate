package ru.daremor.issuemate;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;
import ru.daremor.issuemate.jira.exhange.SearchAndReconcileRequest;
import ru.daremor.issuemate.jira.exhange.SearchAndReconcileResponse;

@Component
@RequiredArgsConstructor
public class JiraSearchClient {

    private final RestClient jiraRestClient;

    public SearchAndReconcileResponse search(String jql, List<String> fields, Integer maxResults) {

        var reqBody = SearchAndReconcileRequest.builder()
        		.addField("summary")
        		.addField("description")
        		.jql(jql)
        		.maxResults(maxResults);

        var rsp = jiraRestClient.post()
                .uri("/rest/api/2/search")
                .body(reqBody)
                .retrieve()
                .onStatus(HttpStatusCode::isError, (req, res) -> {
                    throw new IllegalStateException("Jira search failed: HTTP " + res.getStatusCode());
                })
                .body(SearchAndReconcileResponse.class);

        return rsp;

    }
}
