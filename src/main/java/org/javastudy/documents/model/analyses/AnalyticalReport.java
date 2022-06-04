package org.javastudy.documents.model.analyses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnalyticalReport {
    private Map<String, DocumentTypeAnalyses> analysesByType;
    private Map<String, EmployeeDocumentAnalyses> analysesByEmployee;
}
