package com.saasovation.issuetracker.domain.model.product;

import java.util.UUID;

/**
 *
 */
public class Id {
    public final String id;

    public static final Id newId() {
        return new Id(UUID.randomUUID().toString());
    }

    private Id(String id) {
        this.id = id;
    }
}
