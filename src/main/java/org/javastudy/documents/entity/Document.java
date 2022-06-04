package org.javastudy.documents.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Document {
    public Document(String title) {
        this.title = title;
    }

    /**
     * Номер документа присваивается только один раз и не может быть изменён.
     */
    public void setNumber(Long number) {
        if (this.number != null) {
            throw new IllegalStateException("Number of document can't be changed");
        }
        this.number = number;
    }

    @Id
    @Column(name = "number", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long number;
    @Column(name = "title", nullable = false)
    protected String title;
}
