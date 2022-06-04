package org.javastudy.documents.entity.stuffing;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javastudy.documents.entity.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Кадровый документ.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class StuffingDocument extends Document {
    @Column(name = "employee")
    protected String employee;
    @Column(name = "order_text")
    protected String orderText;
    @Column(name = "status", columnDefinition = "smallint default 0")
    protected OrderStatus status = OrderStatus.CREATED;

    public StuffingDocument(String title, String employee, String orderText) {
        super(title);
        this.employee = employee;
        this.orderText = orderText;
    }

    /**
     * Проверяет текущий статус: нельзя изменить статус исполненного документа.
     * */
    public void setStatus(OrderStatus status) {
        if (this.status == OrderStatus.EXECUTED && this.status != status) {
            throw new IllegalStateException("Cannot change status of executed document");
        }
        this.status = status;
    }

    /**
     * Исполнить приказ.
     */
    public void execute() {
        this.status = OrderStatus.EXECUTED;
    }
}
