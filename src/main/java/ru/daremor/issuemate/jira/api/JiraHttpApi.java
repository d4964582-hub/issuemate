package ru.daremor.issuemate.jira.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import ru.daremor.issuemate.jira.exhange.CommentRequest;
import ru.daremor.issuemate.jira.exhange.SearchAndReconcileRequest;
import ru.daremor.issuemate.jira.exhange.SearchAndReconcileResponse;
import ru.daremor.issuemate.jira.exhange.TransitionRequest;
import ru.daremor.issuemate.jira.exhange.TransitionResponse;
import ru.daremor.issuemate.jira.model.*;

@HttpExchange(accept = MediaType.APPLICATION_JSON_VALUE, contentType = MediaType.APPLICATION_JSON_VALUE)
public interface JiraHttpApi {

    /**
     * Returns the details for an issue.
     * The issue is identified by its ID or key, however, if the identifier doesn't match an issue, a case-insensitive search and check for moved issues is performed. 
     * If a matching issue is found its details are returned, a 302 or other redirect is not returned. 
     * The issue key returned in the response is the key of the issue found.
     * 
     */
    @GetExchange("/rest/api/2/issue/{key}")
    Issue getIssue(@PathVariable("key") String issueKey);
    
    /**
     *
     * Creates an issue or, where the option to create subtasks is enabled in Jira, a subtask. 
     * A transition may be applied, to move the issue or subtask to a workflow step other than the default start step, and issue properties set.
     * The content of the issue or subtask is defined using update and fields. 
     * The fields that can be set in the issue or subtask are determined using the Get create issue metadata. 
     * These are the same fields that appear on the issue's create screen.
     * 
     */
    @PostExchange("/rest/api/2/issue")
    Issue createIssue(Issue issue);
    
    /**
     * 
     * Searches for issues using JQL. 
     * Recent updates might not be immediately visible in the returned search results. 
     * If you need read-after-write consistency, you can utilize the reconcileIssues parameter to ensure stronger consistency assurances. 
     * This operation can be accessed anonymously.
     * 
     */
    @PostExchange("/rest/api/2/search")
    SearchAndReconcileResponse searchIssueByJQL(SearchAndReconcileRequest request);

    /**
     * 
     * Returns either all transitions or a transition that can be performed by the user on an issue, based on the issue's status.
     * Note, if a request is made for a transition that does not exist or cannot be performed on the issue, given its status, the response will return any empty transitions list.
     * This operation can be accessed anonymously.
     * 
     */
    @GetExchange("/rest/api/2/issue/{key}/transitions")
    TransitionResponse getTransitions(@PathVariable("key") String issueKey);

    
    /**
     * Performs an issue transition and, if the transition has a screen, updates the fields from the transition screen.
     * sortByCategory To update the fields on the transition screen, specify the fields in the fields or update parameters in the request body. 
     * Get details about the fields using Get transitions with the transitions.fields expand.
     * This operation can be accessed anonymously.
     * 
     */
    @PostExchange("/rest/api/2/issue/{key}/transitions")
    void doTransition(@PathVariable("key") String issueKey, TransitionRequest request);

    
    /**
     * Performs an issue transition and, if the transition has a screen, updates the fields from the transition screen.
     * sortByCategory To update the fields on the transition screen, specify the fields in the fields or update parameters in the request body. 
     * Get details about the fields using Get transitions with the transitions.fields expand.
     * This operation can be accessed anonymously.
     * 
     */
    @PostExchange("/rest/api/2/issue/{key}/comment")
    Comment addComment(@PathVariable("key") String issueKey, CommentRequest request);
}
