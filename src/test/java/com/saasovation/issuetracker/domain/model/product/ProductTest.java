package com.saasovation.issuetracker.domain.model.product;

import com.saasovation.issuetracker.domain.model.product.issue.Severity;
import com.saasovation.issuetracker.domain.model.product.measurement.DefectDensity;
import com.saasovation.issuetracker.domain.model.product.measurement.DefectStatistics;
import com.saasovation.issuetracker.domain.model.product.measurement.Measurement;
import com.saasovation.issuetracker.domain.model.product.measurement.MeasurementType;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testProduct() throws Exception {
        Product product = new Product("tenant1", Id.newId());
        assertNotNull(product);
    }
/*
    @Test
    public void testDetermineDefectStatistics() throws Exception {

        Product p = new Product("t1", Id.newId());
        p.reportDefect("a defect", "a summary", Severity.LOW);
        p.reportDefect("another defect", "whatever", Severity.MEDIUM);
        p.requestFeature("i want it", "good stuff", Severity.HIGH);
        p.reportDefect("oh no", "i did it again", Severity.HIGH);

        Measurement kloc = new Measurement(MeasurementType.KLOC, 99);

        DefectStatistics defectStatistics = p.determineDefectStatistics(kloc);
        assertEquals(3.0/99.0, defectStatistics.stats,0.0);
    }

    @Test
    public void testCalculateDefectDensities() throws Exception {

        Product p = new Product("t1", Id.newId());
        p.reportDefect("a defect", "a summary", Severity.LOW);
        p.reportDefect("another defect", "whatever", Severity.MEDIUM);
        p.requestFeature("i want it", "good stuff", Severity.HIGH);
        p.reportDefect("oh no", "i did it again", Severity.HIGH);

        List<Measurement> measurements = asList(
                new Measurement(MeasurementType.KLOC, 99),
                new Measurement(MeasurementType.CLASSES, 230),
                new Measurement(MeasurementType.BACKLOG_ITEMS, 850)
        );
        Collection<DefectDensity> defectDensities = p.calculateDefectDensities(measurements);

        assertEquals(3, defectDensities.size());
        Optional<DefectDensity> klocDensity = findDensityForMeasurement(defectDensities, MeasurementType.KLOC);
        assertTrue(klocDensity.isPresent());
        assertEquals(1.6/99, klocDensity.get().indexFigure, 0.0);

        Optional<DefectDensity> classesDensity = findDensityForMeasurement(defectDensities, MeasurementType.CLASSES);
        assertTrue(classesDensity.isPresent());
        assertEquals(1.6 / 230, classesDensity.get().indexFigure, 0.0);

        Optional<DefectDensity> backlogDensity = findDensityForMeasurement(defectDensities, MeasurementType.BACKLOG_ITEMS);
        assertTrue(backlogDensity.isPresent());
        assertEquals(1.6 / 850, backlogDensity.get().indexFigure, 0.0);

    }
*/
    private Optional<DefectDensity> findDensityForMeasurement(Collection<DefectDensity> defectDensities, MeasurementType measurementType) {
        return defectDensities.stream()
                .filter(d -> d.measurementType == measurementType)
                .findFirst();
    }
}