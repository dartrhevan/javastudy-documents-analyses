package org.javastudy.documents.entity.stuffing;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Приказ об увольнении/
 */
@Entity
@NoArgsConstructor
public class FiringOrder extends StuffingDocument {
    @Getter
    @Setter
    @Column(name = "firing_reason")
    private String firingReason;

    public FiringOrder(String title, String employee, String orderText, String firingReason) {
        super(title, employee, orderText);
        this.firingReason = firingReason;
    }

    @Override
    public String toString() {
        return "FiringOrder{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", firingReason='" + firingReason + '\'' +
                ", employee='" + employee + '\'' +
                ", orderText='" + orderText + '\'' +
                ", status=" + status +
                '}';
    }
}
