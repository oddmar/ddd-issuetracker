package com.saasovation.issuetracker.domain.model.product.measurement;

/**
 *
 */
public class DefectStatistics {
    public final double stats;

    public DefectStatistics(long numberOfDefects, Measurement measurement) {
        this.stats = ((double)numberOfDefects)/measurement.count;
    }
}
