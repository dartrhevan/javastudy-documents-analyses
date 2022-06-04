package org.javastudy.documents.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Письмо.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Mail extends Document {
    @Column(name = "sender")
    private String sender;
    @Column(name = "receiver")
    private String receiver;

    public Mail(String title, String sender, String receiver) {
        super(title);
        this.sender = sender;
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                '}';
    }
}
