package com.saasovation.issuetracker.domain.model.product.measurement;

/**
 *
 */
public class Measurement {
    public final MeasurementType type;
    public final int count;

    public Measurement(MeasurementType type, int count) {
        this.type = type;
        this.count = count;
    }
}
