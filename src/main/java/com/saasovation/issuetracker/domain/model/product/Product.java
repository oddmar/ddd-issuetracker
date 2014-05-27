package com.saasovation.issuetracker.domain.model.product;

import com.saasovation.issuetracker.domain.model.product.issue.Issue;
import com.saasovation.issuetracker.domain.model.product.issue.IssueAssigner;
import com.saasovation.issuetracker.domain.model.product.issue.IssueType;
import com.saasovation.issuetracker.domain.model.product.issue.Severity;
import com.saasovation.issuetracker.domain.model.product.measurement.DefectDensity;
import com.saasovation.issuetracker.domain.model.product.measurement.DefectStatistics;
import com.saasovation.issuetracker.domain.model.product.measurement.Measurement;
import com.saasovation.issuetracker.domain.model.product.release.Release;

import java.util.*;
import java.util.stream.Collectors;


/**
 */
public class Product {

    public final Id productId;
    public final String tenantId;
    public String name;
    public String description;
    public ProductManager productManager;
    public IssueAssigner issueAssigner;
    public final Set<Issue> issues = new HashSet<>();
    public final Set<Release> releases = new HashSet<>();

    public Product(String tenantId, Id productId) {
        this.tenantId = tenantId;
        this.productId = productId;
    }

    public Product(String tenantId,
                   Id productId,
                   String name,
                   String description,
                   ProductManager productManager,
                   IssueAssigner issueAssigner) {
        this.productId = productId;
        this.tenantId = tenantId;
        this.name = name;
        this.description = description;
        this.productManager = productManager;
        this.issueAssigner = issueAssigner;
    }

    public void releaseAs(String name) {
        Release release = new Release(Id.newId(), name);
        releases.add(release);
    }

    public DefectStatistics determineDefectStatistics(Measurement klocMeasurement) {
        return new DefectStatistics(getIssuesOfType(IssueType.DEFECT).size(), klocMeasurement);
    }

    public Collection<DefectDensity> calculateDefectDensities(List<Measurement> measurements) {
        Set<Issue> defects = getIssuesOfType(IssueType.DEFECT);
        List<DefectDensity> defectDensities = new ArrayList<>();
        measurements.forEach(m -> defectDensities.add(new DefectDensity(defects, m)));
        return defectDensities;
    }

    private Set<Issue> getIssuesOfType(IssueType type) {
        return issues.stream()
                .filter(i -> i.issueType == type)
                .collect(Collectors.toSet());
    }
}
