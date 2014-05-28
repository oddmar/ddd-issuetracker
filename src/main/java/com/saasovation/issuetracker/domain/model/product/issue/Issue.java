package com.saasovation.issuetracker.domain.model.product.issue;

import com.saasovation.issuetracker.common.domain.model.DomainEventPublisher;
import com.saasovation.issuetracker.domain.model.product.Id;
import com.saasovation.issuetracker.domain.model.product.issue.events.IssueReported;

/**
 */
public class Issue {
    public final String tenantId;
    public final Id productId;
    public final Id issueId;
    public final IssueType issueType;
    public final Severity severity;
    public String summary;
    public String description;

    Issue(String tenantId,
                 Id productId,
                 Id issueId,
                 IssueType issueType,
                 Severity severity,
                 String summary,
                 String description) {
        this.tenantId = tenantId;
        this.productId = productId;
        this.issueId = issueId;
        this.issueType = issueType;
        this.summary = summary;
        this.description = description;
        this.severity = severity;

        IssueReported reportedEvent = new IssueReported(tenantId,
                productId, issueId, issueType, severity, summary, description);
        DomainEventPublisher.instance().publish(reportedEvent);
    }

    public void assign() {
    }

    public void markRejected() {
    }

    public void markDuplicate() {
    }
}
