package com.saasovation.issuetracker.domain.model.product.issue.events;

import com.saasovation.issuetracker.common.domain.model.DomainEvent;

import java.util.Date;

/**
 *
 */
public class IssueClosed implements DomainEvent {
    @Override
    public int eventVersion() {
        return 0;
    }

    @Override
    public Date occurredOn() {
        return null;
    }
}
