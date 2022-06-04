package org.javastudy.documents.model.analyses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentTypeAnalyses {
    private int totalCount;
    private short ratio;
}
