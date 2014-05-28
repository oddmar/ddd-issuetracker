package com.saasovation.issuetracker.domain.model.product.issue;

import com.saasovation.issuetracker.common.domain.model.DomainEventPublisher;
import com.saasovation.issuetracker.common.domain.model.DomainEventSubscriber;
import com.saasovation.issuetracker.domain.model.product.Id;
import com.saasovation.issuetracker.domain.model.product.issue.events.IssueReported;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IssueApplicationServiceTest {

    @Test
    public void testReportDefect() throws Exception {
        final String tenantId = "t1";
        final Id productId = Id.newId();
        final String summary = "This is a summary";
        final String description = "A description";
        final Severity severity = Severity.HIGH;
        IssueApplicationService appService = new IssueApplicationService();

        DomainEventPublisher.instance().subscribe(new DomainEventSubscriber<IssueReported>() {
            @Override
            public void handleEvent(IssueReported aDomainEvent) {
                System.out.println("Event received: " + aDomainEvent.issueId.id);
                assertEquals(tenantId, aDomainEvent.tenantId);
                assertEquals(severity, aDomainEvent.severity);
            }

            @Override
            public Class<IssueReported> subscribedToEventType() {
                return IssueReported.class;
            }
        });

        appService.reportDefect(tenantId, productId, summary, description, severity);
    }
    @Test
    public void testReportDefects() throws Exception {
        final String tenantId = "t1";
        final Id productId = Id.newId();
        final String summary = "This is a summary";
        final String description = "A description";
        final Severity severity = Severity.HIGH;
        IssueApplicationService appService = new IssueApplicationService();
        List<IssueReported> events = new ArrayList<>();

        DomainEventPublisher.instance().subscribe(new DomainEventSubscriber<IssueReported>() {
            @Override
            public void handleEvent(IssueReported aDomainEvent) {
                System.out.println("Event received: " + aDomainEvent.issueId.id);
                events.add(aDomainEvent);
            }

            @Override
            public Class<IssueReported> subscribedToEventType() {
                return IssueReported.class;
            }
        });

        appService.reportDefect(tenantId, productId, summary, description, Severity.HIGH);
        appService.reportDefect(tenantId, productId, summary, description, Severity.LOW);
        appService.reportDefect(tenantId, productId, summary, description, Severity.HIGH);
        appService.reportDefect(tenantId, productId, summary, description, Severity.MEDIUM);
        appService.reportDefect(tenantId, productId, summary, description, Severity.MEDIUM);

        assertEquals(5, events.size());
    }



}