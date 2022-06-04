package org.javastudy.documents.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.javastudy.documents.entity.Document;
import org.javastudy.documents.entity.stuffing.OrderStatus;
import org.javastudy.documents.entity.stuffing.StuffingDocument;
import org.javastudy.documents.model.analyses.AnalyticalReport;
import org.javastudy.documents.model.analyses.DocumentTypeAnalyses;
import org.javastudy.documents.model.analyses.EmployeeDocumentAnalyses;
import org.javastudy.documents.service.AnalysesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Math.round;
import static java.util.stream.Collectors.*;
import static org.javastudy.documents.util.AnalysesUtil.calculateRatio;

@Slf4j
@Service
public class AnalysesServiceImpl implements AnalysesService {
    @Override
    public AnalyticalReport calculateAnalytics(final List<Document> documents) {
        var totalCount = documents.size();
        var analysesByType = documents.stream().collect(
                groupingBy(d -> d.getClass().getSimpleName(), collectingAndThen(counting(), c -> getAnalysesForType(c, totalCount))));
        var analysesByEmployee = documents.stream()
                .filter(StuffingDocument.class::isInstance).map(StuffingDocument.class::cast).collect(
                groupingBy(StuffingDocument::getEmployee, collectingAndThen(groupingBy(StuffingDocument::getStatus), this::getAnalysesForEmployee)));
        var analyticalReport = new AnalyticalReport(analysesByType, analysesByEmployee);
        log.info("Calculate analyses {}", analyticalReport);
        return analyticalReport;
    }

    private DocumentTypeAnalyses getAnalysesForType(final Long count, final int totalCount) {
        return new DocumentTypeAnalyses(Math.toIntExact(count), calculateRatio(count, totalCount));
    }

    private EmployeeDocumentAnalyses getAnalysesForEmployee(final Map<OrderStatus, List<StuffingDocument>> count) {
        var createdDocuments = count.getOrDefault(OrderStatus.CREATED, List.of());
        var executedDocuments = count.getOrDefault(OrderStatus.EXECUTED, List.of());
        var totalCount = createdDocuments.size() + executedDocuments.size();
        return new EmployeeDocumentAnalyses(totalCount, executedDocuments.size(), calculateRatio(executedDocuments.size(), totalCount));
    }
}
