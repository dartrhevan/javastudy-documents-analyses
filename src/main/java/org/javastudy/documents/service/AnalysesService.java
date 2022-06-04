package org.javastudy.documents.service;

import org.javastudy.documents.entity.Document;
import org.javastudy.documents.model.analyses.AnalyticalReport;

import java.util.List;

/**
 * Подсчёт аналитики по документам.
 */
public interface AnalysesService {
    AnalyticalReport calculateAnalytics(List<Document> documents);
}
