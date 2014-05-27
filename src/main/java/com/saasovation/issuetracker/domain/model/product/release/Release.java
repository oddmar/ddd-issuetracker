package com.saasovation.issuetracker.domain.model.product.release;

import com.saasovation.issuetracker.domain.model.product.Id;

/**
 *
 */
public class Release {
    public final Id releaseId;
    public final String name;

    public Release(Id releaseId, String name) {
        this.releaseId = releaseId;
        this.name = name;
    }
}
