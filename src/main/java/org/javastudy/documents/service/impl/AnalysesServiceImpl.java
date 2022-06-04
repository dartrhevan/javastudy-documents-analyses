package org.javastudy.documents.service.impl;

import org.javastudy.documents.entity.Document;
import org.javastudy.documents.model.analyses.AnalyticalReport;
import org.javastudy.documents.service.AnalysesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysesServiceImpl implements AnalysesService {
    @Override
    public AnalyticalReport calculateAnalytics(List<Document> documents) {
        return null;
    }
}
