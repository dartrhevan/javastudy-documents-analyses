package org.javastudy.documents.service;

import org.javastudy.documents.model.analyses.AnalyticalReport;

/**
 * Сервис сохранения рассчитанной аналитики.
 */
public interface AnalysesSaver {
    void saveAnalytics(AnalyticalReport analytics);
}
