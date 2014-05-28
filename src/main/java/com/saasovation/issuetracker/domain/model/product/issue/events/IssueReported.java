package com.saasovation.issuetracker.domain.model.product.issue.events;

import com.saasovation.issuetracker.common.domain.model.DomainEvent;
import com.saasovation.issuetracker.domain.model.product.Id;
import com.saasovation.issuetracker.domain.model.product.issue.IssueType;
import com.saasovation.issuetracker.domain.model.product.issue.Severity;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 */
public class IssueReported implements DomainEvent {

    public final String tenantId;
    public final Id productId;
    public final Id issueId;
    public final IssueType issueType;
    public final Severity severity;
    public final String summary;
    public final String description;
    private final Date dateTime;

    public IssueReported(String tenantId, Id productId, Id issueId,
                         IssueType issueType, Severity severity, String summary, String description) {
        this.tenantId = tenantId;
        this.productId = productId;
        this.issueId = issueId;
        this.issueType = issueType;
        this.severity = severity;
        this.summary = summary;
        this.description = description;
        this.dateTime = new Date();
    }

    @Override
    public int eventVersion() {
        return 0;
    }

    @Override
    public Date occurredOn() {
        return dateTime;
    }
}
