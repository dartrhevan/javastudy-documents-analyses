package org.javastudy.documents.entity.stuffing;

import lombok.NoArgsConstructor;
import javax.persistence.Entity;

/**
 * Приказ о приеме на работу.
 */
@Entity
@NoArgsConstructor
public class HiringOrder extends StuffingDocument {
    public HiringOrder(String title, String employee, String orderText) {
        super(title, employee, orderText);
    }

    @Override
    public String toString() {
        return "HiringOrder{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", employee='" + employee + '\'' +
                ", orderText='" + orderText + '\'' +
                ", status=" + status +
                '}';
    }
}
