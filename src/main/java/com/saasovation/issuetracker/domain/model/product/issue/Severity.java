package com.saasovation.issuetracker.domain.model.product.issue;

/**
 *
 */
public enum Severity {
    HIGH (1.0),
    MEDIUM (0.5),
    LOW (0.1);

    public final double weight;

    Severity(double weight) {
        this.weight = weight;
    }
}
