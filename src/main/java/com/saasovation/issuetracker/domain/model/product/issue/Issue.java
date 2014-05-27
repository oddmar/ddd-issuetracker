package com.saasovation.issuetracker.domain.model.product.issue;

import com.saasovation.issuetracker.domain.model.product.Id;

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

    public Issue(String tenantId,
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
    }

    public void reportDefect(String tenantId, Id productId, String summary, String description, Severity severity) {
        new Issue(tenantId, productId, Id.newId(), IssueType.DEFECT, severity, summary, description);
    }

    public void requestFeature(String summary, String description, Severity severity) {
        new Issue(tenantId, productId, Id.newId(), IssueType.FEATURE_REQUEST, severity, summary, description);
    }

    public void assign() {
    }

    public void markRejected() {
    }

    public void markDuplicate() {
    }
}
