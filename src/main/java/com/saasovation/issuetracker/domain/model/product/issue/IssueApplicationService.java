package com.saasovation.issuetracker.domain.model.product.issue;

import com.saasovation.issuetracker.common.domain.model.DomainEventPublisher;
import com.saasovation.issuetracker.domain.model.product.Id;
import com.saasovation.issuetracker.domain.model.product.issue.events.IssueReported;

/**
 *
 */
public class IssueApplicationService {

    public Issue reportDefect(String tenantId, Id productId, String summary, String description, Severity severity) {
        Issue issue = new Issue(tenantId, productId, Id.newId(), IssueType.DEFECT, severity, summary, description);
        return issue;
    }

    public Issue requestFeature(String tenantId, Id productId, String summary, String description, Severity severity) {
        Issue issue = new Issue(tenantId, productId, Id.newId(), IssueType.FEATURE_REQUEST, severity, summary, description);
        return issue;
    }


}
