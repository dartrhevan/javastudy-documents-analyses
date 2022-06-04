package org.javastudy.documents.model.analyses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.javastudy.documents.entity.stuffing.OrderStatus;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnalyticalReport {
    private Map<Class, Long> documentsCountByType;
    private Map<OrderStatus, Long> documentsCountByStatus;
//    private

}
