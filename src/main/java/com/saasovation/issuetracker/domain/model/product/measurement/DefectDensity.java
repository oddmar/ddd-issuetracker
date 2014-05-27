package com.saasovation.issuetracker.domain.model.product.measurement;

import com.saasovation.issuetracker.domain.model.product.issue.Issue;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 *
 */
public class DefectDensity {
    public final double indexFigure;
    public final LocalDateTime dateTime;
    public final double totalSeverity;
    public final MeasurementType measurementType;

    public DefectDensity(Collection<Issue> issues, Measurement measurement) {
        this.totalSeverity = issues.stream().mapToDouble(i -> i.severity.weight).sum();
        this.dateTime = LocalDateTime.now();
        this.indexFigure = totalSeverity/measurement.count;
        this.measurementType = measurement.type;
    }
}
