package org.javastudy.documents.service;

import org.javastudy.documents.model.analyses.AnalyticalReport;

/**
 * Сервис сохранения рассчитанной аналитики.
 */
public interface AnalyticsSaver {
    void saveAnalytics(AnalyticalReport analytics);
}
