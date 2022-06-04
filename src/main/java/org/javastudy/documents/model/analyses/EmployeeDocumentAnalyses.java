package org.javastudy.documents.model.analyses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDocumentAnalyses {
    private int totalCount;
    private int executedCount;
    private short executionPercentage;
}
